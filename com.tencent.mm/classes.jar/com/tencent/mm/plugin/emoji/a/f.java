package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.emoji.a.a.e;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.bo;

public class f
  extends com.tencent.mm.plugin.emoji.a.a.a
{
  private final String TAG = "MicroMsg.emoji.EmojiStoreMainAdapter";
  public boolean lei = false;
  public boolean lej = true;
  public boolean lek = false;
  public boolean lel = true;
  
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  public View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 1;
    AppMethodBeat.i(52749);
    f.a locala = (f.a)paramView.getTag();
    paramViewGroup = uj(paramInt);
    if (this.lek)
    {
      paramViewGroup.lfg = true;
      paramViewGroup.lfe = false;
      paramViewGroup.lff = false;
    }
    EmotionBannerSet localEmotionBannerSet;
    label128:
    boolean bool;
    if ((locala != null) && (paramViewGroup != null))
    {
      paramViewGroup.lff = this.lel;
      localEmotionBannerSet = paramViewGroup.lfb;
      if (localEmotionBannerSet != null) {
        break label240;
      }
      locala.uf(0);
      paramInt = 0;
      if (paramInt == 0)
      {
        paramViewGroup = paramViewGroup.lfa;
        if (paramViewGroup != null)
        {
          locala.setTitle(paramViewGroup.PackName);
          if (!com.tencent.mm.plugin.emoji.h.a.g(paramViewGroup)) {
            break label363;
          }
          o.ahG().a("", locala.bko());
          locala.bkp();
          bool = e.ea(paramViewGroup.PackType, 2);
          if (TextUtils.isEmpty(paramViewGroup.TagUri)) {
            break label392;
          }
          locala.bkq().setImageDrawable(null);
          locala.bkq().setVisibility(0);
          o.ahG().a(paramViewGroup.TagUri, locala.bkq(), g.dK("", paramViewGroup.TagUri));
          label190:
          if (!bkG()) {
            break label421;
          }
        }
      }
    }
    label392:
    label421:
    for (paramViewGroup = paramViewGroup.ExptDesc;; paramViewGroup = paramViewGroup.Introduce)
    {
      locala.Kh(paramViewGroup);
      if ((this.lei) && (locala.ldA != null)) {
        locala.ldA.setBackgroundResource(2130838447);
      }
      AppMethodBeat.o(52749);
      return paramView;
      label240:
      locala.setTitle(localEmotionBannerSet.Title);
      locala.Kh(localEmotionBannerSet.Desc);
      if (!bo.isNullOrNil(localEmotionBannerSet.IconUrl)) {
        o.ahG().a(localEmotionBannerSet.IconUrl, locala.bko(), g.dK("", localEmotionBannerSet.IconUrl));
      }
      if (!bo.isNullOrNil(localEmotionBannerSet.TagUrl))
      {
        o.ahG().a(localEmotionBannerSet.TagUrl, locala.bkq(), g.dK("", localEmotionBannerSet.TagUrl));
        locala.ue(0);
      }
      for (;;)
      {
        locala.uf(8);
        paramInt = i;
        break;
        locala.ue(8);
      }
      label363:
      o.ahG().a(paramViewGroup.IconUrl, locala.bko(), g.dK(paramViewGroup.ProductID, paramViewGroup.IconUrl));
      break label128;
      if (bool)
      {
        locala.ue(0);
        locala.bkr();
        break label190;
      }
      locala.ue(8);
      break label190;
    }
  }
  
  public int bkC()
  {
    return 0;
  }
  
  public int bkD()
  {
    return 0;
  }
  
  public int bkE()
  {
    return 0;
  }
  
  protected boolean bkG()
  {
    return false;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(52748);
    super.clear();
    AppMethodBeat.o(52748);
  }
  
  public final a d(Context paramContext, View paramView)
  {
    AppMethodBeat.i(52747);
    paramContext = new f.a(this, paramContext, paramView);
    paramContext.a(this.leP);
    AppMethodBeat.o(52747);
    return paramContext;
  }
  
  public void ug(int paramInt) {}
  
  public void uh(int paramInt) {}
  
  public void ui(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.f
 * JD-Core Version:    0.7.0.1
 */