package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.q;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;
import java.util.List;

public class f
  extends com.tencent.mm.plugin.emoji.a.a.a
{
  private final String TAG;
  public boolean pHH;
  public boolean pHI;
  public boolean pHJ;
  public boolean pHK;
  private List<String> pHL;
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(179051);
    this.TAG = "MicroMsg.emoji.EmojiStoreMainAdapter";
    this.pHH = false;
    this.pHI = true;
    this.pHJ = false;
    this.pHK = true;
    this.pHL = new LinkedList();
    AppMethodBeat.o(179051);
  }
  
  public void Cb(int paramInt) {}
  
  public void Cc(int paramInt) {}
  
  public void Cd(int paramInt) {}
  
  public View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 1;
    int i = 0;
    AppMethodBeat.i(108325);
    a locala = (a)paramView.getTag();
    paramViewGroup = Ce(paramInt);
    if (this.pHJ)
    {
      paramViewGroup.pIF = true;
      paramViewGroup.pID = false;
      paramViewGroup.pIE = false;
    }
    Object localObject;
    label131:
    boolean bool;
    if ((locala != null) && (paramViewGroup != null))
    {
      paramViewGroup.pIE = this.pHK;
      localObject = paramViewGroup.pIA;
      if (localObject != null) {
        break label278;
      }
      locala.Ca(0);
      paramInt = 0;
      if (paramInt == 0)
      {
        paramViewGroup = paramViewGroup.pIz;
        if (paramViewGroup != null)
        {
          locala.setTitle(paramViewGroup.PackName);
          if (!com.tencent.mm.plugin.emoji.h.a.g(paramViewGroup)) {
            break label401;
          }
          q.aJb().loadImage("", locala.chl());
          locala.chm();
          bool = com.tencent.mm.plugin.emoji.a.a.e.fl(paramViewGroup.PackType, 2);
          if (TextUtils.isEmpty(paramViewGroup.TagUri)) {
            break label430;
          }
          locala.chn().setImageDrawable(null);
          locala.chn().setVisibility(0);
          q.aJb().a(paramViewGroup.TagUri, locala.chn(), com.tencent.mm.plugin.emoji.e.e.fy("", paramViewGroup.TagUri));
          label193:
          localObject = locala.pHc;
          if (!this.pHL.contains(paramViewGroup.ProductID)) {
            break label459;
          }
          paramInt = i;
          label219:
          ((View)localObject).setVisibility(paramInt);
          if (bu.isNullOrNil(paramViewGroup.ExptDesc)) {
            break label465;
          }
        }
      }
    }
    label278:
    label430:
    label459:
    label465:
    for (paramViewGroup = paramViewGroup.ExptDesc;; paramViewGroup = paramViewGroup.Introduce)
    {
      locala.abX(paramViewGroup);
      if ((this.pHH) && (locala.pGZ != null)) {
        locala.pGZ.setBackgroundResource(2131231820);
      }
      AppMethodBeat.o(108325);
      return paramView;
      locala.setTitle(((EmotionBannerSet)localObject).Title);
      locala.abX(((EmotionBannerSet)localObject).Desc);
      if (!bu.isNullOrNil(((EmotionBannerSet)localObject).IconUrl)) {
        q.aJb().a(((EmotionBannerSet)localObject).IconUrl, locala.chl(), com.tencent.mm.plugin.emoji.e.e.fy("", ((EmotionBannerSet)localObject).IconUrl));
      }
      if (!bu.isNullOrNil(((EmotionBannerSet)localObject).TagUrl))
      {
        q.aJb().a(((EmotionBannerSet)localObject).TagUrl, locala.chn(), com.tencent.mm.plugin.emoji.e.e.fy("", ((EmotionBannerSet)localObject).TagUrl));
        locala.BZ(0);
      }
      for (;;)
      {
        locala.Ca(8);
        paramInt = j;
        break;
        locala.BZ(8);
      }
      q.aJb().a(paramViewGroup.IconUrl, locala.chl(), com.tencent.mm.plugin.emoji.e.e.fy(paramViewGroup.ProductID, paramViewGroup.IconUrl));
      break label131;
      if (bool)
      {
        locala.BZ(0);
        locala.cho();
        break label193;
      }
      locala.BZ(8);
      break label193;
      paramInt = 8;
      break label219;
    }
  }
  
  public final void cQ(List<String> paramList)
  {
    AppMethodBeat.i(179052);
    this.pHL.clear();
    if (paramList != null) {
      this.pHL.addAll(paramList);
    }
    AppMethodBeat.o(179052);
  }
  
  public int chA()
  {
    return 0;
  }
  
  public int chy()
  {
    return 0;
  }
  
  public int chz()
  {
    return 0;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(108324);
    super.clear();
    AppMethodBeat.o(108324);
  }
  
  public final a d(Context paramContext, View paramView)
  {
    AppMethodBeat.i(108323);
    paramContext = new a(paramContext, paramView);
    paramContext.a(this.pIo);
    AppMethodBeat.o(108323);
    return paramContext;
  }
  
  public final class a
    extends a
  {
    public a(Context paramContext, View paramView)
    {
      super(paramView);
    }
    
    protected final void chh()
    {
      AppMethodBeat.i(108319);
      this.pHb.setVisibility(8);
      chp();
      this.pHf.setVisibility(8);
      this.pHj.setVisibility(8);
      this.pHk.setVisibility(8);
      this.pHa.setVisibility(0);
      this.lHk.setVisibility(0);
      this.pHh.setVisibility(0);
      this.pHg.setVisibility(0);
      this.pHi.setVisibility(0);
      AppMethodBeat.o(108319);
    }
    
    protected final int[] chi()
    {
      AppMethodBeat.i(108320);
      int i = com.tencent.mm.cb.a.ax(this.mContext, 2131166234);
      AppMethodBeat.o(108320);
      return new int[] { i, i };
    }
    
    protected final int chj()
    {
      AppMethodBeat.i(108321);
      int i = com.tencent.mm.cb.a.ax(this.mContext, 2131166233);
      AppMethodBeat.o(108321);
      return i;
    }
    
    protected final boolean chs()
    {
      AppMethodBeat.i(108322);
      boolean bool = f.a(f.this);
      AppMethodBeat.o(108322);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.f
 * JD-Core Version:    0.7.0.1
 */