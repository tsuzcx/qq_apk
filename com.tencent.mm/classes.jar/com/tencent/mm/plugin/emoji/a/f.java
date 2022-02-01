package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.q;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;
import java.util.List;

public class f
  extends com.tencent.mm.plugin.emoji.a.a.a
{
  private final String TAG;
  public boolean pBd;
  public boolean pBe;
  public boolean pBf;
  public boolean pBg;
  private List<String> pBh;
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(179051);
    this.TAG = "MicroMsg.emoji.EmojiStoreMainAdapter";
    this.pBd = false;
    this.pBe = true;
    this.pBf = false;
    this.pBg = true;
    this.pBh = new LinkedList();
    AppMethodBeat.o(179051);
  }
  
  public void BP(int paramInt) {}
  
  public void BQ(int paramInt) {}
  
  public void BR(int paramInt) {}
  
  public View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 1;
    int i = 0;
    AppMethodBeat.i(108325);
    a locala = (a)paramView.getTag();
    paramViewGroup = BS(paramInt);
    if (this.pBf)
    {
      paramViewGroup.pCb = true;
      paramViewGroup.pBZ = false;
      paramViewGroup.pCa = false;
    }
    Object localObject;
    label131:
    boolean bool;
    if ((locala != null) && (paramViewGroup != null))
    {
      paramViewGroup.pCa = this.pBg;
      localObject = paramViewGroup.pBW;
      if (localObject != null) {
        break label278;
      }
      locala.BO(0);
      paramInt = 0;
      if (paramInt == 0)
      {
        paramViewGroup = paramViewGroup.pBV;
        if (paramViewGroup != null)
        {
          locala.setTitle(paramViewGroup.PackName);
          if (!com.tencent.mm.plugin.emoji.h.a.g(paramViewGroup)) {
            break label401;
          }
          q.aIJ().loadImage("", locala.cfV());
          locala.cfW();
          bool = com.tencent.mm.plugin.emoji.a.a.e.fk(paramViewGroup.PackType, 2);
          if (TextUtils.isEmpty(paramViewGroup.TagUri)) {
            break label430;
          }
          locala.cfX().setImageDrawable(null);
          locala.cfX().setVisibility(0);
          q.aIJ().a(paramViewGroup.TagUri, locala.cfX(), com.tencent.mm.plugin.emoji.e.e.fu("", paramViewGroup.TagUri));
          label193:
          localObject = locala.pAy;
          if (!this.pBh.contains(paramViewGroup.ProductID)) {
            break label459;
          }
          paramInt = i;
          label219:
          ((View)localObject).setVisibility(paramInt);
          if (bt.isNullOrNil(paramViewGroup.ExptDesc)) {
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
      locala.abg(paramViewGroup);
      if ((this.pBd) && (locala.pAv != null)) {
        locala.pAv.setBackgroundResource(2131231820);
      }
      AppMethodBeat.o(108325);
      return paramView;
      locala.setTitle(((EmotionBannerSet)localObject).Title);
      locala.abg(((EmotionBannerSet)localObject).Desc);
      if (!bt.isNullOrNil(((EmotionBannerSet)localObject).IconUrl)) {
        q.aIJ().a(((EmotionBannerSet)localObject).IconUrl, locala.cfV(), com.tencent.mm.plugin.emoji.e.e.fu("", ((EmotionBannerSet)localObject).IconUrl));
      }
      if (!bt.isNullOrNil(((EmotionBannerSet)localObject).TagUrl))
      {
        q.aIJ().a(((EmotionBannerSet)localObject).TagUrl, locala.cfX(), com.tencent.mm.plugin.emoji.e.e.fu("", ((EmotionBannerSet)localObject).TagUrl));
        locala.BN(0);
      }
      for (;;)
      {
        locala.BO(8);
        paramInt = j;
        break;
        locala.BN(8);
      }
      q.aIJ().a(paramViewGroup.IconUrl, locala.cfV(), com.tencent.mm.plugin.emoji.e.e.fu(paramViewGroup.ProductID, paramViewGroup.IconUrl));
      break label131;
      if (bool)
      {
        locala.BN(0);
        locala.cfY();
        break label193;
      }
      locala.BN(8);
      break label193;
      paramInt = 8;
      break label219;
    }
  }
  
  public final void cN(List<String> paramList)
  {
    AppMethodBeat.i(179052);
    this.pBh.clear();
    if (paramList != null) {
      this.pBh.addAll(paramList);
    }
    AppMethodBeat.o(179052);
  }
  
  public int cgi()
  {
    return 0;
  }
  
  public int cgj()
  {
    return 0;
  }
  
  public int cgk()
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
    paramContext.a(this.pBK);
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
    
    protected final void cfR()
    {
      AppMethodBeat.i(108319);
      this.pAx.setVisibility(8);
      cfZ();
      this.pAB.setVisibility(8);
      this.pAF.setVisibility(8);
      this.pAG.setVisibility(8);
      this.pAw.setVisibility(0);
      this.lCL.setVisibility(0);
      this.pAD.setVisibility(0);
      this.pAC.setVisibility(0);
      this.pAE.setVisibility(0);
      AppMethodBeat.o(108319);
    }
    
    protected final int[] cfS()
    {
      AppMethodBeat.i(108320);
      int i = com.tencent.mm.cc.a.ax(this.mContext, 2131166234);
      AppMethodBeat.o(108320);
      return new int[] { i, i };
    }
    
    protected final int cfT()
    {
      AppMethodBeat.i(108321);
      int i = com.tencent.mm.cc.a.ax(this.mContext, 2131166233);
      AppMethodBeat.o(108321);
      return i;
    }
    
    protected final boolean cgc()
    {
      AppMethodBeat.i(108322);
      boolean bool = f.a(f.this);
      AppMethodBeat.o(108322);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.f
 * JD-Core Version:    0.7.0.1
 */