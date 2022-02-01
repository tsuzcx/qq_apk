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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;
import java.util.List;

public class FavSearchActionView
  extends LinearLayout
{
  public FavTagPanel qOc;
  public List<Integer> qPw;
  public a qUA;
  private ImageButton qUx;
  public List<String> qUy;
  public List<String> qUz;
  
  public FavSearchActionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(107534);
    this.qPw = new LinkedList();
    this.qUy = new LinkedList();
    this.qUz = new LinkedList();
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
  
  public static Integer ap(Context paramContext, String paramString)
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
  
  private void crC()
  {
    AppMethodBeat.i(107538);
    if ((this.qPw.isEmpty()) && (this.qUy.isEmpty()))
    {
      this.qOc.setEditHint(getResources().getString(2131755882));
      AppMethodBeat.o(107538);
      return;
    }
    this.qOc.setEditHint("");
    AppMethodBeat.o(107538);
  }
  
  public final void ac(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(107539);
    this.qPw.clear();
    this.qPw.add(Integer.valueOf(paramInt));
    if (this.qOc == null)
    {
      AppMethodBeat.o(107539);
      return;
    }
    crC();
    this.qOc.setType(T(getContext(), paramInt));
    if (this.qUA == null)
    {
      AppMethodBeat.o(107539);
      return;
    }
    adc(this.qOc.getEditText());
    if (paramBoolean) {
      this.qUA.a(this.qPw, this.qUz, this.qUy, false);
    }
    h.wUl.f(11126, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(107539);
  }
  
  public final void adc(String paramString)
  {
    AppMethodBeat.i(107536);
    this.qUz.clear();
    paramString = bs.bG(paramString, "").split(" ");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramString[i];
      if (!bs.isNullOrNil(str)) {
        this.qUz.add(str);
      }
      i += 1;
    }
    AppMethodBeat.o(107536);
  }
  
  public List<String> getSearchKeys()
  {
    AppMethodBeat.i(107537);
    if (this.qOc != null) {
      adc(this.qOc.getEditText());
    }
    List localList = this.qUz;
    AppMethodBeat.o(107537);
    return localList;
  }
  
  public List<String> getSearchTags()
  {
    return this.qUy;
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(107535);
    super.onFinishInflate();
    this.qUx = ((ImageButton)findViewById(2131304401));
    this.qOc = ((FavTagPanel)findViewById(2131299843));
    if (this.qOc != null)
    {
      this.qOc.setEditTextColor(getResources().getColor(2131100021));
      this.qOc.setTagTipsDrawable(0);
      this.qOc.setTagHighlineBG(0);
      this.qOc.setTagSelectedBG(0);
      this.qOc.setTagSelectedTextColorRes(2131101171);
      this.qOc.setTagNormalBG(0);
      this.qOc.setTagNormalTextColorRes(2131101179);
      this.qOc.setEditHint(getResources().getString(2131755882));
      this.qOc.wR(true);
      this.qOc.HzG = false;
      this.qOc.HzH = true;
      this.qOc.setCallBack(new FavTagPanel.a()
      {
        public final void C(boolean paramAnonymousBoolean, int paramAnonymousInt) {}
        
        public final void YA(String paramAnonymousString)
        {
          AppMethodBeat.i(107530);
          FavSearchActionView.a(FavSearchActionView.this, paramAnonymousString);
          FavSearchActionView.d(FavSearchActionView.this).a(FavSearchActionView.e(FavSearchActionView.this), FavSearchActionView.f(FavSearchActionView.this), FavSearchActionView.b(FavSearchActionView.this), false);
          AppMethodBeat.o(107530);
        }
        
        public final void Yw(String paramAnonymousString)
        {
          AppMethodBeat.i(107527);
          ac.d("MicroMsg.FavSearchActionView", "unselected tag %s", new Object[] { paramAnonymousString });
          FavSearchActionView.a(FavSearchActionView.this).removeTag(paramAnonymousString);
          Yy(paramAnonymousString);
          AppMethodBeat.o(107527);
        }
        
        public final void Yx(String paramAnonymousString) {}
        
        public final void Yy(String paramAnonymousString)
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
        
        public final void Yz(String paramAnonymousString)
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
        
        public final void add(String paramAnonymousString)
        {
          AppMethodBeat.i(107532);
          ac.d("MicroMsg.FavSearchActionView", "unselected type %s", new Object[] { paramAnonymousString });
          FavSearchActionView.a(FavSearchActionView.this);
          FavSearchActionView.a(FavSearchActionView.this, FavSearchActionView.a(FavSearchActionView.this).getEditText());
          FavSearchActionView.e(FavSearchActionView.this).remove(FavSearchActionView.ap(FavSearchActionView.this.getContext(), paramAnonymousString));
          FavSearchActionView.c(FavSearchActionView.this);
          if (FavSearchActionView.d(FavSearchActionView.this) != null) {
            FavSearchActionView.d(FavSearchActionView.this).a(FavSearchActionView.e(FavSearchActionView.this), FavSearchActionView.f(FavSearchActionView.this), FavSearchActionView.b(FavSearchActionView.this), true);
          }
          AppMethodBeat.o(107532);
        }
        
        public final void cep()
        {
          AppMethodBeat.i(107531);
          if (FavSearchActionView.d(FavSearchActionView.this) == null)
          {
            AppMethodBeat.o(107531);
            return;
          }
          FavSearchActionView.d(FavSearchActionView.this).aPb();
          AppMethodBeat.o(107531);
        }
      });
    }
    if (this.qUx != null) {
      this.qUx.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107533);
          if (FavSearchActionView.d(FavSearchActionView.this) == null)
          {
            AppMethodBeat.o(107533);
            return;
          }
          FavSearchActionView.a(FavSearchActionView.this).fiP();
          FavSearchActionView.a(FavSearchActionView.this).fiK();
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
    this.qUA = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, List<Integer> paramList, List<String> paramList1, List<String> paramList2);
    
    public abstract void a(List<Integer> paramList, List<String> paramList1, List<String> paramList2, boolean paramBoolean);
    
    public abstract void aPb();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView
 * JD-Core Version:    0.7.0.1
 */