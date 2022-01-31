package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;
import java.util.List;

public class FavSearchActionView
  extends LinearLayout
{
  private ImageView lzc;
  private ImageButton mEh;
  public List<String> mEi;
  public List<String> mEj;
  public FavSearchActionView.a mEk;
  public FavTagPanel mya;
  public List<Integer> mzr;
  
  public FavSearchActionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(74689);
    this.mzr = new LinkedList();
    this.mEi = new LinkedList();
    this.mEj = new LinkedList();
    AppMethodBeat.o(74689);
  }
  
  private static String N(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(74695);
    if (paramContext == null)
    {
      AppMethodBeat.o(74695);
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
      AppMethodBeat.o(74695);
      return "";
    case 21: 
      paramContext = paramContext.getString(2131299833);
      AppMethodBeat.o(74695);
      return paramContext;
    case 5: 
      paramContext = paramContext.getString(2131299838);
      AppMethodBeat.o(74695);
      return paramContext;
    case 8: 
      paramContext = paramContext.getString(2131299831);
      AppMethodBeat.o(74695);
      return paramContext;
    case 7: 
      paramContext = paramContext.getString(2131299835);
      AppMethodBeat.o(74695);
      return paramContext;
    case 17: 
      paramContext = paramContext.getString(2131299837);
      AppMethodBeat.o(74695);
      return paramContext;
    case 3: 
      paramContext = paramContext.getString(2131299840);
      AppMethodBeat.o(74695);
      return paramContext;
    case 18: 
      paramContext = paramContext.getString(2131299836);
      AppMethodBeat.o(74695);
      return paramContext;
    }
    paramContext = paramContext.getString(2131299834);
    AppMethodBeat.o(74695);
    return paramContext;
  }
  
  public static Integer ao(Context paramContext, String paramString)
  {
    AppMethodBeat.i(74696);
    if (paramContext == null)
    {
      AppMethodBeat.o(74696);
      return Integer.valueOf(-1);
    }
    if (paramContext.getString(2131299833).equals(paramString))
    {
      AppMethodBeat.o(74696);
      return Integer.valueOf(21);
    }
    if (paramContext.getString(2131299838).equals(paramString))
    {
      AppMethodBeat.o(74696);
      return Integer.valueOf(5);
    }
    if (paramContext.getString(2131299831).equals(paramString))
    {
      AppMethodBeat.o(74696);
      return Integer.valueOf(8);
    }
    if (paramContext.getString(2131299835).equals(paramString))
    {
      AppMethodBeat.o(74696);
      return Integer.valueOf(7);
    }
    if (paramContext.getString(2131299837).equals(paramString))
    {
      AppMethodBeat.o(74696);
      return Integer.valueOf(17);
    }
    if (paramContext.getString(2131299840).equals(paramString))
    {
      AppMethodBeat.o(74696);
      return Integer.valueOf(3);
    }
    if (paramContext.getString(2131299836).equals(paramString))
    {
      AppMethodBeat.o(74696);
      return Integer.valueOf(18);
    }
    if (paramContext.getString(2131299834).equals(paramString))
    {
      AppMethodBeat.o(74696);
      return Integer.valueOf(6);
    }
    AppMethodBeat.o(74696);
    return Integer.valueOf(-1);
  }
  
  private void bys()
  {
    AppMethodBeat.i(74693);
    if ((this.mzr.isEmpty()) && (this.mEi.isEmpty()))
    {
      this.mya.setEditHint(getResources().getString(2131297065));
      AppMethodBeat.o(74693);
      return;
    }
    this.mya.setEditHint("");
    AppMethodBeat.o(74693);
  }
  
  public final void Of(String paramString)
  {
    AppMethodBeat.i(74691);
    this.mEj.clear();
    paramString = bo.bf(paramString, "").split(" ");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramString[i];
      if (!bo.isNullOrNil(str)) {
        this.mEj.add(str);
      }
      i += 1;
    }
    AppMethodBeat.o(74691);
  }
  
  public final void U(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(74694);
    this.mzr.clear();
    this.mzr.add(Integer.valueOf(paramInt));
    if (this.mya == null)
    {
      AppMethodBeat.o(74694);
      return;
    }
    bys();
    this.mya.setType(N(getContext(), paramInt));
    if (this.mEk == null)
    {
      AppMethodBeat.o(74694);
      return;
    }
    Of(this.mya.getEditText());
    if (paramBoolean) {
      this.mEk.a(this.mzr, this.mEj, this.mEi, false);
    }
    h.qsU.e(11126, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(74694);
  }
  
  public List<String> getSearchKeys()
  {
    AppMethodBeat.i(74692);
    if (this.mya != null) {
      Of(this.mya.getEditText());
    }
    List localList = this.mEj;
    AppMethodBeat.o(74692);
    return localList;
  }
  
  public List<String> getSearchTags()
  {
    return this.mEi;
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(74690);
    super.onFinishInflate();
    this.mEh = ((ImageButton)findViewById(2131824083));
    this.mya = ((FavTagPanel)findViewById(2131824082));
    this.lzc = ((ImageView)findViewById(2131820993));
    if (this.mya != null)
    {
      this.mya.setEditTextColor(getResources().getColor(2131689766));
      this.mya.setTagTipsDrawable(0);
      this.mya.setTagHighlineBG(0);
      this.mya.setTagSelectedBG(0);
      this.mya.setTagSelectedTextColorRes(2131689778);
      this.mya.setTagNormalBG(0);
      this.mya.setTagNormalTextColorRes(2131690709);
      this.mya.setEditHint(getResources().getString(2131297065));
      this.mya.qF(true);
      this.mya.zmp = false;
      this.mya.zmq = true;
      this.mya.setCallBack(new FavSearchActionView.1(this));
    }
    if (this.mEh != null) {
      this.mEh.setOnClickListener(new FavSearchActionView.2(this));
    }
    AppMethodBeat.o(74690);
  }
  
  public void setOnSearchChangedListener(FavSearchActionView.a parama)
  {
    this.mEk = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView
 * JD-Core Version:    0.7.0.1
 */