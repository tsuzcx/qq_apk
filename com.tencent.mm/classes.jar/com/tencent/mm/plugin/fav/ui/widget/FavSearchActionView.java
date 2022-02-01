package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;
import java.util.List;

public class FavSearchActionView
  extends LinearLayout
{
  public FavTagPanel qfA;
  public List<Integer> qgU;
  private ImageButton qlV;
  public List<String> qlW;
  public List<String> qlX;
  public a qlY;
  
  public FavSearchActionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(107534);
    this.qgU = new LinkedList();
    this.qlW = new LinkedList();
    this.qlX = new LinkedList();
    AppMethodBeat.o(107534);
  }
  
  public static String P(Context paramContext, int paramInt)
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
  
  public static Integer ao(Context paramContext, String paramString)
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
  
  private void cjV()
  {
    AppMethodBeat.i(107538);
    if ((this.qgU.isEmpty()) && (this.qlW.isEmpty()))
    {
      this.qfA.setEditHint(getResources().getString(2131755882));
      AppMethodBeat.o(107538);
      return;
    }
    this.qfA.setEditHint("");
    AppMethodBeat.o(107538);
  }
  
  public final void YG(String paramString)
  {
    AppMethodBeat.i(107536);
    this.qlX.clear();
    paramString = bt.by(paramString, "").split(" ");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramString[i];
      if (!bt.isNullOrNil(str)) {
        this.qlX.add(str);
      }
      i += 1;
    }
    AppMethodBeat.o(107536);
  }
  
  public final void ac(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(107539);
    this.qgU.clear();
    this.qgU.add(Integer.valueOf(paramInt));
    if (this.qfA == null)
    {
      AppMethodBeat.o(107539);
      return;
    }
    cjV();
    this.qfA.setType(P(getContext(), paramInt));
    if (this.qlY == null)
    {
      AppMethodBeat.o(107539);
      return;
    }
    YG(this.qfA.getEditText());
    if (paramBoolean) {
      this.qlY.a(this.qgU, this.qlX, this.qlW, false);
    }
    h.vKh.f(11126, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(107539);
  }
  
  public List<String> getSearchKeys()
  {
    AppMethodBeat.i(107537);
    if (this.qfA != null) {
      YG(this.qfA.getEditText());
    }
    List localList = this.qlX;
    AppMethodBeat.o(107537);
    return localList;
  }
  
  public List<String> getSearchTags()
  {
    return this.qlW;
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(107535);
    super.onFinishInflate();
    this.qlV = ((ImageButton)findViewById(2131304401));
    this.qfA = ((FavTagPanel)findViewById(2131299843));
    if (this.qfA != null)
    {
      this.qfA.setEditTextColor(getResources().getColor(2131100021));
      this.qfA.setTagTipsDrawable(0);
      this.qfA.setTagHighlineBG(0);
      this.qfA.setTagSelectedBG(0);
      this.qfA.setTagSelectedTextColorRes(2131101171);
      this.qfA.setTagNormalBG(0);
      this.qfA.setTagNormalTextColorRes(2131101179);
      this.qfA.setEditHint(getResources().getString(2131755882));
      this.qfA.vN(true);
      this.qfA.FZS = false;
      this.qfA.FZT = true;
      this.qfA.setCallBack(new FavTagPanel.a()
      {
        public final void B(boolean paramAnonymousBoolean, int paramAnonymousInt) {}
        
        public final void Uk(String paramAnonymousString)
        {
          AppMethodBeat.i(107527);
          ad.d("MicroMsg.FavSearchActionView", "unselected tag %s", new Object[] { paramAnonymousString });
          FavSearchActionView.a(FavSearchActionView.this).removeTag(paramAnonymousString);
          Um(paramAnonymousString);
          AppMethodBeat.o(107527);
        }
        
        public final void Ul(String paramAnonymousString) {}
        
        public final void Um(String paramAnonymousString)
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
        
        public final void Un(String paramAnonymousString)
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
        
        public final void Uo(String paramAnonymousString)
        {
          AppMethodBeat.i(107530);
          FavSearchActionView.a(FavSearchActionView.this, paramAnonymousString);
          FavSearchActionView.d(FavSearchActionView.this).a(FavSearchActionView.e(FavSearchActionView.this), FavSearchActionView.f(FavSearchActionView.this), FavSearchActionView.b(FavSearchActionView.this), false);
          AppMethodBeat.o(107530);
        }
        
        public final void YH(String paramAnonymousString)
        {
          AppMethodBeat.i(107532);
          ad.d("MicroMsg.FavSearchActionView", "unselected type %s", new Object[] { paramAnonymousString });
          FavSearchActionView.a(FavSearchActionView.this);
          FavSearchActionView.a(FavSearchActionView.this, FavSearchActionView.a(FavSearchActionView.this).getEditText());
          FavSearchActionView.e(FavSearchActionView.this).remove(FavSearchActionView.ao(FavSearchActionView.this.getContext(), paramAnonymousString));
          FavSearchActionView.c(FavSearchActionView.this);
          if (FavSearchActionView.d(FavSearchActionView.this) != null) {
            FavSearchActionView.d(FavSearchActionView.this).a(FavSearchActionView.e(FavSearchActionView.this), FavSearchActionView.f(FavSearchActionView.this), FavSearchActionView.b(FavSearchActionView.this), true);
          }
          AppMethodBeat.o(107532);
        }
        
        public final void bXc()
        {
          AppMethodBeat.i(107531);
          if (FavSearchActionView.d(FavSearchActionView.this) == null)
          {
            AppMethodBeat.o(107531);
            return;
          }
          FavSearchActionView.d(FavSearchActionView.this).aIk();
          AppMethodBeat.o(107531);
        }
      });
    }
    if (this.qlV != null) {
      this.qlV.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107533);
          if (FavSearchActionView.d(FavSearchActionView.this) == null)
          {
            AppMethodBeat.o(107533);
            return;
          }
          FavSearchActionView.a(FavSearchActionView.this).eTf();
          FavSearchActionView.a(FavSearchActionView.this).eTa();
          FavSearchActionView.f(FavSearchActionView.this).clear();
          FavSearchActionView.b(FavSearchActionView.this).clear();
          FavSearchActionView.d(FavSearchActionView.this).a(FavSearchActionView.e(FavSearchActionView.this), FavSearchActionView.f(FavSearchActionView.this), FavSearchActionView.b(FavSearchActionView.this), true);
          FavSearchActionView.c(FavSearchActionView.this);
          AppMethodBeat.o(107533);
        }
      });
    }
    AppMethodBeat.o(107535);
  }
  
  public void setOnSearchChangedListener(a parama)
  {
    this.qlY = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, List<Integer> paramList, List<String> paramList1, List<String> paramList2);
    
    public abstract void a(List<Integer> paramList, List<String> paramList1, List<String> paramList2, boolean paramBoolean);
    
    public abstract void aIk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView
 * JD-Core Version:    0.7.0.1
 */