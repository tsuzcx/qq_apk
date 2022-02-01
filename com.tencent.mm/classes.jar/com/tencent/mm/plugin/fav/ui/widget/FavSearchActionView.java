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
import com.tencent.mm.plugin.fav.ui.q.b;
import com.tencent.mm.plugin.fav.ui.q.e;
import com.tencent.mm.plugin.fav.ui.q.i;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public class FavSearchActionView
  extends LinearLayout
{
  public FavTagPanel AiE;
  public List<Integer> Akg;
  public List<String> ApJ;
  public List<String> ApK;
  public a ApL;
  private ImageButton mpf;
  
  public FavSearchActionView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(107534);
    this.Akg = new LinkedList();
    this.ApJ = new LinkedList();
    this.ApK = new LinkedList();
    AppMethodBeat.o(107534);
  }
  
  public static Integer aA(Context paramContext, String paramString)
  {
    AppMethodBeat.i(107541);
    if (paramContext == null)
    {
      AppMethodBeat.o(107541);
      return Integer.valueOf(-1);
    }
    if (paramContext.getString(q.i.favorite_sub_title_imageandvideo).equals(paramString))
    {
      AppMethodBeat.o(107541);
      return Integer.valueOf(21);
    }
    if (paramContext.getString(q.i.favorite_sub_title_url).equals(paramString))
    {
      AppMethodBeat.o(107541);
      return Integer.valueOf(5);
    }
    if (paramContext.getString(q.i.favorite_sub_title_file).equals(paramString))
    {
      AppMethodBeat.o(107541);
      return Integer.valueOf(8);
    }
    if (paramContext.getString(q.i.favorite_sub_title_music).equals(paramString))
    {
      AppMethodBeat.o(107541);
      return Integer.valueOf(7);
    }
    if (paramContext.getString(q.i.favorite_sub_title_record).equals(paramString))
    {
      AppMethodBeat.o(107541);
      return Integer.valueOf(17);
    }
    if (paramContext.getString(q.i.favorite_sub_title_voice).equals(paramString))
    {
      AppMethodBeat.o(107541);
      return Integer.valueOf(3);
    }
    if (paramContext.getString(q.i.favorite_sub_title_note).equals(paramString))
    {
      AppMethodBeat.o(107541);
      return Integer.valueOf(18);
    }
    if (paramContext.getString(q.i.favorite_sub_title_location).equals(paramString))
    {
      AppMethodBeat.o(107541);
      return Integer.valueOf(6);
    }
    AppMethodBeat.o(107541);
    return Integer.valueOf(-1);
  }
  
  public static String al(Context paramContext, int paramInt)
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
      paramContext = paramContext.getString(q.i.favorite_sub_title_imageandvideo);
      AppMethodBeat.o(107540);
      return paramContext;
    case 5: 
      paramContext = paramContext.getString(q.i.favorite_sub_title_url);
      AppMethodBeat.o(107540);
      return paramContext;
    case 8: 
      paramContext = paramContext.getString(q.i.favorite_sub_title_file);
      AppMethodBeat.o(107540);
      return paramContext;
    case 7: 
      paramContext = paramContext.getString(q.i.favorite_sub_title_music);
      AppMethodBeat.o(107540);
      return paramContext;
    case 17: 
      paramContext = paramContext.getString(q.i.favorite_sub_title_record);
      AppMethodBeat.o(107540);
      return paramContext;
    case 3: 
      paramContext = paramContext.getString(q.i.favorite_sub_title_voice);
      AppMethodBeat.o(107540);
      return paramContext;
    case 18: 
      paramContext = paramContext.getString(q.i.favorite_sub_title_note);
      AppMethodBeat.o(107540);
      return paramContext;
    case 6: 
      paramContext = paramContext.getString(q.i.favorite_sub_title_location);
      AppMethodBeat.o(107540);
      return paramContext;
    }
    paramContext = paramContext.getString(q.i.favorite_sub_title_recently_used);
    AppMethodBeat.o(107540);
    return paramContext;
  }
  
  private void dSQ()
  {
    AppMethodBeat.i(107538);
    if ((this.Akg.isEmpty()) && (this.ApJ.isEmpty()))
    {
      this.AiE.setEditHint(getResources().getString(q.i.app_search));
      AppMethodBeat.o(107538);
      return;
    }
    this.AiE.setEditHint("");
    AppMethodBeat.o(107538);
  }
  
  public final void aA(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(107539);
    this.Akg.clear();
    this.Akg.add(Integer.valueOf(paramInt));
    if (this.AiE == null)
    {
      AppMethodBeat.o(107539);
      return;
    }
    dSQ();
    this.AiE.setType(al(getContext(), paramInt));
    if (this.ApL == null)
    {
      AppMethodBeat.o(107539);
      return;
    }
    auH(this.AiE.getEditText());
    if (paramBoolean) {
      this.ApL.a(this.Akg, this.ApK, this.ApJ, false);
    }
    h.OAn.b(11126, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(107539);
  }
  
  public final void auH(String paramString)
  {
    AppMethodBeat.i(107536);
    this.ApK.clear();
    paramString = Util.nullAs(paramString, "").split(" ");
    int j = paramString.length;
    int i = 0;
    while (i < j)
    {
      String str = paramString[i];
      if (!Util.isNullOrNil(str)) {
        this.ApK.add(str);
      }
      i += 1;
    }
    AppMethodBeat.o(107536);
  }
  
  public List<String> getSearchKeys()
  {
    AppMethodBeat.i(107537);
    if (this.AiE != null) {
      auH(this.AiE.getEditText());
    }
    List localList = this.ApK;
    AppMethodBeat.o(107537);
    return localList;
  }
  
  public List<String> getSearchTags()
  {
    return this.ApJ;
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(107535);
    super.onFinishInflate();
    this.mpf = ((ImageButton)findViewById(q.e.search_clear_button));
    this.AiE = ((FavTagPanel)findViewById(q.e.fav_tag_input_panel));
    if (this.AiE != null)
    {
      this.AiE.setEditTextColor(getResources().getColor(q.b.black_text_color));
      this.AiE.setTagTipsDrawable(0);
      this.AiE.setTagHighlineBG(0);
      this.AiE.setTagSelectedBG(0);
      this.AiE.setTagSelectedTextColorRes(q.b.wechat_green);
      this.AiE.setTagNormalBG(0);
      this.AiE.setTagNormalTextColorRes(q.b.white);
      this.AiE.setEditHint(getResources().getString(q.i.app_search));
      this.AiE.LD(true);
      this.AiE.adTF = false;
      this.AiE.adTG = true;
      this.AiE.setCallBack(new FavTagPanel.a()
      {
        public final void G(boolean paramAnonymousBoolean, int paramAnonymousInt) {}
        
        public final void aoT(String paramAnonymousString)
        {
          AppMethodBeat.i(107527);
          Log.d("MicroMsg.FavSearchActionView", "unselected tag %s", new Object[] { paramAnonymousString });
          FavSearchActionView.a(FavSearchActionView.this).aue(paramAnonymousString);
          aoV(paramAnonymousString);
          AppMethodBeat.o(107527);
        }
        
        public final void aoU(String paramAnonymousString) {}
        
        public final void aoV(String paramAnonymousString)
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
        
        public final void aoW(String paramAnonymousString)
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
        
        public final void aoX(String paramAnonymousString)
        {
          AppMethodBeat.i(107530);
          FavSearchActionView.a(FavSearchActionView.this, paramAnonymousString);
          FavSearchActionView.d(FavSearchActionView.this).a(FavSearchActionView.e(FavSearchActionView.this), FavSearchActionView.f(FavSearchActionView.this), FavSearchActionView.b(FavSearchActionView.this), false);
          AppMethodBeat.o(107530);
        }
        
        public final void auI(String paramAnonymousString)
        {
          AppMethodBeat.i(107532);
          Log.d("MicroMsg.FavSearchActionView", "unselected type %s", new Object[] { paramAnonymousString });
          FavSearchActionView.a(FavSearchActionView.this);
          FavSearchActionView.a(FavSearchActionView.this, FavSearchActionView.a(FavSearchActionView.this).getEditText());
          FavSearchActionView.e(FavSearchActionView.this).remove(FavSearchActionView.aA(FavSearchActionView.this.getContext(), paramAnonymousString));
          FavSearchActionView.c(FavSearchActionView.this);
          if (FavSearchActionView.d(FavSearchActionView.this) != null) {
            FavSearchActionView.d(FavSearchActionView.this).a(FavSearchActionView.e(FavSearchActionView.this), FavSearchActionView.f(FavSearchActionView.this), FavSearchActionView.b(FavSearchActionView.this), true);
          }
          AppMethodBeat.o(107532);
        }
        
        public final void dCx()
        {
          AppMethodBeat.i(107531);
          if (FavSearchActionView.d(FavSearchActionView.this) == null)
          {
            AppMethodBeat.o(107531);
            return;
          }
          FavSearchActionView.d(FavSearchActionView.this).bWx();
          AppMethodBeat.o(107531);
        }
      });
    }
    if (this.mpf != null) {
      this.mpf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(107533);
          b localb = new b();
          localb.cH(paramAnonymousView);
          a.c("com/tencent/mm/plugin/fav/ui/widget/FavSearchActionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          if (FavSearchActionView.d(FavSearchActionView.this) == null)
          {
            a.a(this, "com/tencent/mm/plugin/fav/ui/widget/FavSearchActionView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107533);
            return;
          }
          FavSearchActionView.a(FavSearchActionView.this).jmL();
          FavSearchActionView.a(FavSearchActionView.this).jmG();
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
    this.ApL = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(String paramString, List<Integer> paramList, List<String> paramList1, List<String> paramList2);
    
    public abstract void a(List<Integer> paramList, List<String> paramList1, List<String> paramList2, boolean paramBoolean);
    
    public abstract void bWx();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavSearchActionView
 * JD-Core Version:    0.7.0.1
 */