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
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public class FavSearchActionView
  extends LinearLayout
{
  private ImageButton hey;
  public FavTagPanel tfS;
  public List<Integer> thn;
  public List<String> tmI;
  public List<String> tmJ;
  public a tmK;
  
  public FavSearchActionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(107534);
    this.thn = new LinkedList();
    this.tmI = new LinkedList();
    this.tmJ = new LinkedList();
    AppMethodBeat.o(107534);
  }
  
  public static String Y(Context paramContext, int paramInt)
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
      paramContext = paramContext.getString(2131759335);
      AppMethodBeat.o(107540);
      return paramContext;
    case 5: 
      paramContext = paramContext.getString(2131759340);
      AppMethodBeat.o(107540);
      return paramContext;
    case 8: 
      paramContext = paramContext.getString(2131759331);
      AppMethodBeat.o(107540);
      return paramContext;
    case 7: 
      paramContext = paramContext.getString(2131759337);
      AppMethodBeat.o(107540);
      return paramContext;
    case 17: 
      paramContext = paramContext.getString(2131759339);
      AppMethodBeat.o(107540);
      return paramContext;
    case 3: 
      paramContext = paramContext.getString(2131759342);
      AppMethodBeat.o(107540);
      return paramContext;
    case 18: 
      paramContext = paramContext.getString(2131759338);
      AppMethodBeat.o(107540);
      return paramContext;
    }
    paramContext = paramContext.getString(2131759336);
    AppMethodBeat.o(107540);
    return paramContext;
  }
  
  public static Integer az(Context paramContext, String paramString)
  {
    AppMethodBeat.i(107541);
    if (paramContext == null)
    {
      AppMethodBeat.o(107541);
      return Integer.valueOf(-1);
    }
    if (paramContext.getString(2131759335).equals(paramString))
    {
      AppMethodBeat.o(107541);
      return Integer.valueOf(21);
    }
    if (paramContext.getString(2131759340).equals(paramString))
    {
      AppMethodBeat.o(107541);
      return Integer.valueOf(5);
    }
    if (paramContext.getString(2131759331).equals(paramString))
    {
      AppMethodBeat.o(107541);
      return Integer.valueOf(8);
    }
    if (paramContext.getString(2131759337).equals(paramString))
    {
      AppMethodBeat.o(107541);
      return Integer.valueOf(7);
    }
    if (paramContext.getString(2131759339).equals(paramString))
    {
      AppMethodBeat.o(107541);
      return Integer.valueOf(17);
    }
    if (paramContext.getString(2131759342).equals(paramString))
    {
      AppMethodBeat.o(107541);
      return Integer.valueOf(3);
    }
    if (paramContext.getString(2131759338).equals(paramString))
    {
      AppMethodBeat.o(107541);
      return Integer.valueOf(18);
    }
    if (paramContext.getString(2131759336).equals(paramString))
    {
      AppMethodBeat.o(107541);
      return Integer.valueOf(6);
    }
    AppMethodBeat.o(107541);
    return Integer.valueOf(-1);
  }
  
  private void cWS()
  {
    AppMethodBeat.i(107538);
    if ((this.thn.isEmpty()) && (this.tmI.isEmpty()))
    {
      this.tfS.setEditHint(getResources().getString(2131755972));
      AppMethodBeat.o(107538);
      return;
    }
    this.tfS.setEditHint("");
    AppMethodBeat.o(107538);
  }
  
  public final void aj(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(107539);
    this.thn.clear();
    this.thn.add(Integer.valueOf(paramInt));
    if (this.tfS == null)
    {
      AppMethodBeat.o(107539);
      return;
    }
    cWS();
    this.tfS.setType(Y(getContext(), paramInt));
    if (this.tmK == null)
    {
      AppMethodBeat.o(107539);
      return;
    }
    asw(this.tfS.getEditText());
    if (paramBoolean) {
      this.tmK.a(this.thn, this.tmJ, this.tmI, false);
    }
    h.CyF.a(11126, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(107539);
  }
  
  public final void asw(String paramString)
  {
    AppMethodBeat.i(107536);
    this.tmJ.clear();
    paramString = Util.nullAs(paramString, "").split(" ");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramString[i];
      if (!Util.isNullOrNil(str)) {
        this.tmJ.add(str);
      }
      i += 1;
    }
    AppMethodBeat.o(107536);
  }
  
  public List<String> getSearchKeys()
  {
    AppMethodBeat.i(107537);
    if (this.tfS != null) {
      asw(this.tfS.getEditText());
    }
    List localList = this.tmJ;
    AppMethodBeat.o(107537);
    return localList;
  }
  
  public List<String> getSearchTags()
  {
    return this.tmI;
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(107535);
    super.onFinishInflate();
    this.hey = ((ImageButton)findViewById(2131307366));
    this.tfS = ((FavTagPanel)findViewById(2131300521));
    if (this.tfS != null)
    {
      this.tfS.setEditTextColor(getResources().getColor(2131100047));
      this.tfS.setTagTipsDrawable(0);
      this.tfS.setTagHighlineBG(0);
      this.tfS.setTagSelectedBG(0);
      this.tfS.setTagSelectedTextColorRes(2131101414);
      this.tfS.setTagNormalBG(0);
      this.tfS.setTagNormalTextColorRes(2131101424);
      this.tfS.setEditHint(getResources().getString(2131755972));
      this.tfS.Bz(true);
      this.tfS.OTf = false;
      this.tfS.OTg = true;
      this.tfS.setCallBack(new FavTagPanel.a()
      {
        public final void E(boolean paramAnonymousBoolean, int paramAnonymousInt) {}
        
        public final void anb(String paramAnonymousString)
        {
          AppMethodBeat.i(107527);
          Log.d("MicroMsg.FavSearchActionView", "unselected tag %s", new Object[] { paramAnonymousString });
          FavSearchActionView.a(FavSearchActionView.this).removeTag(paramAnonymousString);
          and(paramAnonymousString);
          AppMethodBeat.o(107527);
        }
        
        public final void anc(String paramAnonymousString) {}
        
        public final void and(String paramAnonymousString)
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
        
        public final void ane(String paramAnonymousString)
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
        
        public final void anf(String paramAnonymousString)
        {
          AppMethodBeat.i(107530);
          FavSearchActionView.a(FavSearchActionView.this, paramAnonymousString);
          FavSearchActionView.d(FavSearchActionView.this).a(FavSearchActionView.e(FavSearchActionView.this), FavSearchActionView.f(FavSearchActionView.this), FavSearchActionView.b(FavSearchActionView.this), false);
          AppMethodBeat.o(107530);
        }
        
        public final void asx(String paramAnonymousString)
        {
          AppMethodBeat.i(107532);
          Log.d("MicroMsg.FavSearchActionView", "unselected type %s", new Object[] { paramAnonymousString });
          FavSearchActionView.a(FavSearchActionView.this);
          FavSearchActionView.a(FavSearchActionView.this, FavSearchActionView.a(FavSearchActionView.this).getEditText());
          FavSearchActionView.e(FavSearchActionView.this).remove(FavSearchActionView.az(FavSearchActionView.this.getContext(), paramAnonymousString));
          FavSearchActionView.c(FavSearchActionView.this);
          if (FavSearchActionView.d(FavSearchActionView.this) != null) {
            FavSearchActionView.d(FavSearchActionView.this).a(FavSearchActionView.e(FavSearchActionView.this), FavSearchActionView.f(FavSearchActionView.this), FavSearchActionView.b(FavSearchActionView.this), true);
          }
          AppMethodBeat.o(107532);
        }
        
        public final void cIk()
        {
          AppMethodBeat.i(107531);
          if (FavSearchActionView.d(FavSearchActionView.this) == null)
          {
            AppMethodBeat.o(107531);
            return;
          }
          FavSearchActionView.d(FavSearchActionView.this).bnz();
          AppMethodBeat.o(107531);
        }
      });
    }
    if (this.hey != null) {
      this.hey.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107533);
          b localb = new b();
          localb.bm(paramAnonymousView);
          a.b("com/tencent/mm/plugin/fav/ui/widget/FavSearchActionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          if (FavSearchActionView.d(FavSearchActionView.this) == null)
          {
            a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavSearchActionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107533);
            return;
          }
          FavSearchActionView.a(FavSearchActionView.this).gLh();
          FavSearchActionView.a(FavSearchActionView.this).gLc();
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
    this.tmK = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, List<Integer> paramList, List<String> paramList1, List<String> paramList2);
    
    public abstract void a(List<Integer> paramList, List<String> paramList1, List<String> paramList2, boolean paramBoolean);
    
    public abstract void bnz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView
 * JD-Core Version:    0.7.0.1
 */