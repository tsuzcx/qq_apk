package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.o;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;
import java.util.List;

public class f
  extends com.tencent.mm.plugin.emoji.a.a.a
{
  private final String TAG;
  public boolean oXt;
  public boolean oXu;
  public boolean oXv;
  public boolean oXw;
  private List<String> oXx;
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(179051);
    this.TAG = "MicroMsg.emoji.EmojiStoreMainAdapter";
    this.oXt = false;
    this.oXu = true;
    this.oXv = false;
    this.oXw = true;
    this.oXx = new LinkedList();
    AppMethodBeat.o(179051);
  }
  
  public void Bh(int paramInt) {}
  
  public void Bi(int paramInt) {}
  
  public void Bj(int paramInt) {}
  
  public View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 1;
    int i = 0;
    AppMethodBeat.i(108325);
    a locala = (a)paramView.getTag();
    paramViewGroup = Bk(paramInt);
    if (this.oXv)
    {
      paramViewGroup.oYr = true;
      paramViewGroup.oYp = false;
      paramViewGroup.oYq = false;
    }
    Object localObject;
    label131:
    boolean bool;
    if ((locala != null) && (paramViewGroup != null))
    {
      paramViewGroup.oYq = this.oXw;
      localObject = paramViewGroup.oYm;
      if (localObject != null) {
        break label278;
      }
      locala.Bg(0);
      paramInt = 0;
      if (paramInt == 0)
      {
        paramViewGroup = paramViewGroup.oYl;
        if (paramViewGroup != null)
        {
          locala.setTitle(paramViewGroup.PackName);
          if (!com.tencent.mm.plugin.emoji.h.a.g(paramViewGroup)) {
            break label401;
          }
          o.aFB().loadImage("", locala.cbr());
          locala.cbs();
          bool = com.tencent.mm.plugin.emoji.a.a.e.fg(paramViewGroup.PackType, 2);
          if (TextUtils.isEmpty(paramViewGroup.TagUri)) {
            break label430;
          }
          locala.cbt().setImageDrawable(null);
          locala.cbt().setVisibility(0);
          o.aFB().a(paramViewGroup.TagUri, locala.cbt(), com.tencent.mm.plugin.emoji.e.e.fk("", paramViewGroup.TagUri));
          label193:
          localObject = locala.oWO;
          if (!this.oXx.contains(paramViewGroup.ProductID)) {
            break label459;
          }
          paramInt = i;
          label219:
          ((View)localObject).setVisibility(paramInt);
          if (bs.isNullOrNil(paramViewGroup.ExptDesc)) {
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
      locala.Xz(paramViewGroup);
      if ((this.oXt) && (locala.oWL != null)) {
        locala.oWL.setBackgroundResource(2131231820);
      }
      AppMethodBeat.o(108325);
      return paramView;
      locala.setTitle(((EmotionBannerSet)localObject).Title);
      locala.Xz(((EmotionBannerSet)localObject).Desc);
      if (!bs.isNullOrNil(((EmotionBannerSet)localObject).IconUrl)) {
        o.aFB().a(((EmotionBannerSet)localObject).IconUrl, locala.cbr(), com.tencent.mm.plugin.emoji.e.e.fk("", ((EmotionBannerSet)localObject).IconUrl));
      }
      if (!bs.isNullOrNil(((EmotionBannerSet)localObject).TagUrl))
      {
        o.aFB().a(((EmotionBannerSet)localObject).TagUrl, locala.cbt(), com.tencent.mm.plugin.emoji.e.e.fk("", ((EmotionBannerSet)localObject).TagUrl));
        locala.Bf(0);
      }
      for (;;)
      {
        locala.Bg(8);
        paramInt = j;
        break;
        locala.Bf(8);
      }
      o.aFB().a(paramViewGroup.IconUrl, locala.cbr(), com.tencent.mm.plugin.emoji.e.e.fk(paramViewGroup.ProductID, paramViewGroup.IconUrl));
      break label131;
      if (bool)
      {
        locala.Bf(0);
        locala.cbu();
        break label193;
      }
      locala.Bf(8);
      break label193;
      paramInt = 8;
      break label219;
    }
  }
  
  public final void cM(List<String> paramList)
  {
    AppMethodBeat.i(179052);
    this.oXx.clear();
    if (paramList != null) {
      this.oXx.addAll(paramList);
    }
    AppMethodBeat.o(179052);
  }
  
  public int cbE()
  {
    return 0;
  }
  
  public int cbF()
  {
    return 0;
  }
  
  public int cbG()
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
    paramContext.a(this.oYa);
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
    
    protected final void cbn()
    {
      AppMethodBeat.i(108319);
      this.oWN.setVisibility(8);
      cbv();
      this.oWR.setVisibility(8);
      this.oWV.setVisibility(8);
      this.oWW.setVisibility(8);
      this.oWM.setVisibility(0);
      this.lfN.setVisibility(0);
      this.oWT.setVisibility(0);
      this.oWS.setVisibility(0);
      this.oWU.setVisibility(0);
      AppMethodBeat.o(108319);
    }
    
    protected final int[] cbo()
    {
      AppMethodBeat.i(108320);
      int i = com.tencent.mm.cc.a.au(this.mContext, 2131166234);
      AppMethodBeat.o(108320);
      return new int[] { i, i };
    }
    
    protected final int cbp()
    {
      AppMethodBeat.i(108321);
      int i = com.tencent.mm.cc.a.au(this.mContext, 2131166233);
      AppMethodBeat.o(108321);
      return i;
    }
    
    protected final boolean cby()
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