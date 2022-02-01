package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;
import java.util.List;

public class FavSearchActionView
  extends LinearLayout
{
  public FavTagPanel rGm;
  public List<Integer> rHG;
  private ImageButton rMW;
  public List<String> rMX;
  public List<String> rMY;
  public a rMZ;
  
  public FavSearchActionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(107534);
    this.rHG = new LinkedList();
    this.rMX = new LinkedList();
    this.rMY = new LinkedList();
    AppMethodBeat.o(107534);
  }
  
  public static String T(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(107540);
    if (paramContext == null)
    {
      AppMethodBeat.o(107540);
      return "";
    }
    switch (paramInt)
    {
    case 4: 
    case 9: 
    case 10: 
    case 11: 
    case 12: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 19: 
    case 20: 
    default: 
      AppMethodBeat.o(107540);
      return "";
    case 21: 
      paramContext = paramContext.getString(2131759009);
      AppMethodBeat.o(107540);
      return paramContext;
    case 5: 
      paramContext = paramContext.getString(2131759014);
      AppMethodBeat.o(107540);
      return paramContext;
    case 8: 
      paramContext = paramContext.getString(2131759006);
      AppMethodBeat.o(107540);
      return paramContext;
    case 7: 
      paramContext = paramContext.getString(2131759011);
      AppMethodBeat.o(107540);
      return paramContext;
    case 17: 
      paramContext = paramContext.getString(2131759013);
      AppMethodBeat.o(107540);
      return paramContext;
    case 3: 
      paramContext = paramContext.getString(2131759016);
      AppMethodBeat.o(107540);
      return paramContext;
    case 18: 
      paramContext = paramContext.getString(2131759012);
      AppMethodBeat.o(107540);
      return paramContext;
    }
    paramContext = paramContext.getString(2131759010);
    AppMethodBeat.o(107540);
    return paramContext;
  }
  
  public static Integer aq(Context paramContext, String paramString)
  {
    AppMethodBeat.i(107541);
    if (paramContext == null)
    {
      AppMethodBeat.o(107541);
      return Integer.valueOf(-1);
    }
    if (paramContext.getString(2131759009).equals(paramString))
    {
      AppMethodBeat.o(107541);
      return Integer.valueOf(21);
    }
    if (paramContext.getString(2131759014).equals(paramString))
    {
      AppMethodBeat.o(107541);
      return Integer.valueOf(5);
    }
    if (paramContext.getString(2131759006).equals(paramString))
    {
      AppMethodBeat.o(107541);
      return Integer.valueOf(8);
    }
    if (paramContext.getString(2131759011).equals(paramString))
    {
      AppMethodBeat.o(107541);
      return Integer.valueOf(7);
    }
    if (paramContext.getString(2131759013).equals(paramString))
    {
      AppMethodBeat.o(107541);
      return Integer.valueOf(17);
    }
    if (paramContext.getString(2131759016).equals(paramString))
    {
      AppMethodBeat.o(107541);
      return Integer.valueOf(3);
    }
    if (paramContext.getString(2131759012).equals(paramString))
    {
      AppMethodBeat.o(107541);
      return Integer.valueOf(18);
    }
    if (paramContext.getString(2131759010).equals(paramString))
    {
      AppMethodBeat.o(107541);
      return Integer.valueOf(6);
    }
    AppMethodBeat.o(107541);
    return Integer.valueOf(-1);
  }
  
  private void cyP()
  {
    AppMethodBeat.i(107538);
    if ((this.rHG.isEmpty()) && (this.rMX.isEmpty()))
    {
      this.rGm.setEditHint(getResources().getString(2131755882));
      AppMethodBeat.o(107538);
      return;
    }
    this.rGm.setEditHint("");
    AppMethodBeat.o(107538);
  }
  
  public final void ae(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(107539);
    this.rHG.clear();
    this.rHG.add(Integer.valueOf(paramInt));
    if (this.rGm == null)
    {
      AppMethodBeat.o(107539);
      return;
    }
    cyP();
    this.rGm.setType(T(getContext(), paramInt));
    if (this.rMZ == null)
    {
      AppMethodBeat.o(107539);
      return;
    }
    ahO(this.rGm.getEditText());
    if (paramBoolean) {
      this.rMZ.a(this.rHG, this.rMY, this.rMX, false);
    }
    g.yxI.f(11126, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(107539);
  }
  
  public final void ahO(String paramString)
  {
    AppMethodBeat.i(107536);
    this.rMY.clear();
    paramString = bu.bI(paramString, "").split(" ");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramString[i];
      if (!bu.isNullOrNil(str)) {
        this.rMY.add(str);
      }
      i += 1;
    }
    AppMethodBeat.o(107536);
  }
  
  public List<String> getSearchKeys()
  {
    AppMethodBeat.i(107537);
    if (this.rGm != null) {
      ahO(this.rGm.getEditText());
    }
    List localList = this.rMY;
    AppMethodBeat.o(107537);
    return localList;
  }
  
  public List<String> getSearchTags()
  {
    return this.rMX;
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(107535);
    super.onFinishInflate();
    this.rMW = ((ImageButton)findViewById(2131304401));
    this.rGm = ((FavTagPanel)findViewById(2131299843));
    if (this.rGm != null)
    {
      this.rGm.setEditTextColor(getResources().getColor(2131100021));
      this.rGm.setTagTipsDrawable(0);
      this.rGm.setTagHighlineBG(0);
      this.rGm.setTagSelectedBG(0);
      this.rGm.setTagSelectedTextColorRes(2131101171);
      this.rGm.setTagNormalBG(0);
      this.rGm.setTagNormalTextColorRes(2131101179);
      this.rGm.setEditHint(getResources().getString(2131755882));
      this.rGm.xK(true);
      this.rGm.JIm = false;
      this.rGm.JIn = true;
      this.rGm.setCallBack(new FavTagPanel.a()
      {
        public final void D(boolean paramAnonymousBoolean, int paramAnonymousInt) {}
        
        public final void acT(String paramAnonymousString)
        {
          AppMethodBeat.i(107527);
          ae.d("MicroMsg.FavSearchActionView", "unselected tag %s", new Object[] { paramAnonymousString });
          FavSearchActionView.a(FavSearchActionView.this).removeTag(paramAnonymousString);
          acV(paramAnonymousString);
          AppMethodBeat.o(107527);
        }
        
        public final void acU(String paramAnonymousString) {}
        
        public final void acV(String paramAnonymousString)
        {
          AppMethodBeat.i(107528);
          FavSearchActionView.a(FavSearchActionView.this, FavSearchActionView.a(FavSearchActionView.this).getEditText());
          FavSearchActionView.b(FavSearchActionView.this).remove(paramAnonymousString);
          FavSearchActionView.c(FavSearchActionView.this);
          if (FavSearchActionView.d(FavSearchActionView.this) == null)
          {
            AppMethodBeat.o(107528);
            return;
          }
          FavSearchActionView.d(FavSearchActionView.this).a(FavSearchActionView.e(FavSearchActionView.this), FavSearchActionView.f(FavSearchActionView.this), FavSearchActionView.b(FavSearchActionView.this), true);
          AppMethodBeat.o(107528);
        }
        
        public final void acW(String paramAnonymousString)
        {
          AppMethodBeat.i(107529);
          FavSearchActionView.a(FavSearchActionView.this, FavSearchActionView.a(FavSearchActionView.this).getEditText());
          FavSearchActionView.c(FavSearchActionView.this);
          if (FavSearchActionView.d(FavSearchActionView.this) == null)
          {
            AppMethodBeat.o(107529);
            return;
          }
          FavSearchActionView.d(FavSearchActionView.this).a(paramAnonymousString, FavSearchActionView.e(FavSearchActionView.this), FavSearchActionView.f(FavSearchActionView.this), FavSearchActionView.b(FavSearchActionView.this));
          AppMethodBeat.o(107529);
        }
        
        public final void acX(String paramAnonymousString)
        {
          AppMethodBeat.i(107530);
          FavSearchActionView.a(FavSearchActionView.this, paramAnonymousString);
          FavSearchActionView.d(FavSearchActionView.this).a(FavSearchActionView.e(FavSearchActionView.this), FavSearchActionView.f(FavSearchActionView.this), FavSearchActionView.b(FavSearchActionView.this), false);
          AppMethodBeat.o(107530);
        }
        
        public final void ahP(String paramAnonymousString)
        {
          AppMethodBeat.i(107532);
          ae.d("MicroMsg.FavSearchActionView", "unselected type %s", new Object[] { paramAnonymousString });
          FavSearchActionView.a(FavSearchActionView.this);
          FavSearchActionView.a(FavSearchActionView.this, FavSearchActionView.a(FavSearchActionView.this).getEditText());
          FavSearchActionView.e(FavSearchActionView.this).remove(FavSearchActionView.aq(FavSearchActionView.this.getContext(), paramAnonymousString));
          FavSearchActionView.c(FavSearchActionView.this);
          if (FavSearchActionView.d(FavSearchActionView.this) != null) {
            FavSearchActionView.d(FavSearchActionView.this).a(FavSearchActionView.e(FavSearchActionView.this), FavSearchActionView.f(FavSearchActionView.this), FavSearchActionView.b(FavSearchActionView.this), true);
          }
          AppMethodBeat.o(107532);
        }
        
        public final void cki()
        {
          AppMethodBeat.i(107531);
          if (FavSearchActionView.d(FavSearchActionView.this) == null)
          {
            AppMethodBeat.o(107531);
            return;
          }
          FavSearchActionView.d(FavSearchActionView.this).aSM();
          AppMethodBeat.o(107531);
        }
      });
    }
    if (this.rMW != null) {
      this.rMW.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107533);
          b localb = new b();
          localb.bd(paramAnonymousView);
          a.b("com/tencent/mm/plugin/fav/ui/widget/FavSearchActionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
          if (FavSearchActionView.d(FavSearchActionView.this) == null)
          {
            a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavSearchActionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107533);
            return;
          }
          FavSearchActionView.a(FavSearchActionView.this).fDg();
          FavSearchActionView.a(FavSearchActionView.this).fDb();
          FavSearchActionView.f(FavSearchActionView.this).clear();
          FavSearchActionView.b(FavSearchActionView.this).clear();
          FavSearchActionView.d(FavSearchActionView.this).a(FavSearchActionView.e(FavSearchActionView.this), FavSearchActionView.f(FavSearchActionView.this), FavSearchActionView.b(FavSearchActionView.this), true);
          FavSearchActionView.c(FavSearchActionView.this);
          a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavSearchActionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107533);
        }
      });
    }
    AppMethodBeat.o(107535);
  }
  
  public void setOnSearchChangedListener(a parama)
  {
    this.rMZ = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, List<Integer> paramList, List<String> paramList1, List<String> paramList2);
    
    public abstract void a(List<Integer> paramList, List<String> paramList1, List<String> paramList2, boolean paramBoolean);
    
    public abstract void aSM();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView
 * JD-Core Version:    0.7.0.1
 */