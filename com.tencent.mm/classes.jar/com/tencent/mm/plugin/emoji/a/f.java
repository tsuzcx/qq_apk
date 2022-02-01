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
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public class f
  extends com.tencent.mm.plugin.emoji.a.a.a
{
  private final String TAG;
  public boolean qXt;
  public boolean qXu;
  public boolean qXv;
  public boolean qXw;
  private List<String> qXx;
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(179051);
    this.TAG = "MicroMsg.emoji.EmojiStoreMainAdapter";
    this.qXt = false;
    this.qXu = true;
    this.qXv = false;
    this.qXw = true;
    this.qXx = new LinkedList();
    AppMethodBeat.o(179051);
  }
  
  public void FK(int paramInt) {}
  
  public void FL(int paramInt) {}
  
  public void FM(int paramInt) {}
  
  public View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 1;
    int i = 0;
    AppMethodBeat.i(108325);
    a locala = (a)paramView.getTag();
    paramViewGroup = FN(paramInt);
    if (this.qXv)
    {
      paramViewGroup.qYr = true;
      paramViewGroup.qYp = false;
      paramViewGroup.qYq = false;
    }
    Object localObject;
    label131:
    boolean bool;
    if ((locala != null) && (paramViewGroup != null))
    {
      paramViewGroup.qYq = this.qXw;
      localObject = paramViewGroup.qYm;
      if (localObject != null) {
        break label278;
      }
      locala.FJ(0);
      paramInt = 0;
      if (paramInt == 0)
      {
        paramViewGroup = paramViewGroup.qYl;
        if (paramViewGroup != null)
        {
          locala.setTitle(paramViewGroup.PackName);
          if (!com.tencent.mm.plugin.emoji.h.a.g(paramViewGroup)) {
            break label401;
          }
          q.bcV().loadImage("", locala.cEX());
          locala.cEY();
          bool = com.tencent.mm.plugin.emoji.a.a.e.fA(paramViewGroup.PackType, 2);
          if (TextUtils.isEmpty(paramViewGroup.TagUri)) {
            break label430;
          }
          locala.cEZ().setImageDrawable(null);
          locala.cEZ().setVisibility(0);
          q.bcV().a(paramViewGroup.TagUri, locala.cEZ(), com.tencent.mm.plugin.emoji.e.e.fQ("", paramViewGroup.TagUri));
          label193:
          localObject = locala.qWO;
          if (!this.qXx.contains(paramViewGroup.ProductID)) {
            break label459;
          }
          paramInt = i;
          label219:
          ((View)localObject).setVisibility(paramInt);
          if (Util.isNullOrNil(paramViewGroup.ExptDesc)) {
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
      locala.alZ(paramViewGroup);
      if ((this.qXt) && (locala.qWL != null)) {
        locala.qWL.setBackgroundResource(2131231901);
      }
      AppMethodBeat.o(108325);
      return paramView;
      locala.setTitle(((EmotionBannerSet)localObject).Title);
      locala.alZ(((EmotionBannerSet)localObject).Desc);
      if (!Util.isNullOrNil(((EmotionBannerSet)localObject).IconUrl)) {
        q.bcV().a(((EmotionBannerSet)localObject).IconUrl, locala.cEX(), com.tencent.mm.plugin.emoji.e.e.fQ("", ((EmotionBannerSet)localObject).IconUrl));
      }
      if (!Util.isNullOrNil(((EmotionBannerSet)localObject).TagUrl))
      {
        q.bcV().a(((EmotionBannerSet)localObject).TagUrl, locala.cEZ(), com.tencent.mm.plugin.emoji.e.e.fQ("", ((EmotionBannerSet)localObject).TagUrl));
        locala.FI(0);
      }
      for (;;)
      {
        locala.FJ(8);
        paramInt = j;
        break;
        locala.FI(8);
      }
      q.bcV().a(paramViewGroup.IconUrl, locala.cEX(), com.tencent.mm.plugin.emoji.e.e.fQ(paramViewGroup.ProductID, paramViewGroup.IconUrl));
      break label131;
      if (bool)
      {
        locala.FI(0);
        locala.cFa();
        break label193;
      }
      locala.FI(8);
      break label193;
      paramInt = 8;
      break label219;
    }
  }
  
  public int cFk()
  {
    return 0;
  }
  
  public int cFl()
  {
    return 0;
  }
  
  public int cFm()
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
    paramContext.a(this.qYa);
    AppMethodBeat.o(108323);
    return paramContext;
  }
  
  public final void df(List<String> paramList)
  {
    AppMethodBeat.i(179052);
    this.qXx.clear();
    if (paramList != null) {
      this.qXx.addAll(paramList);
    }
    AppMethodBeat.o(179052);
  }
  
  public final class a
    extends a
  {
    public a(Context paramContext, View paramView)
    {
      super(paramView);
    }
    
    protected final void cET()
    {
      AppMethodBeat.i(108319);
      this.qWN.setVisibility(8);
      cFb();
      this.qWR.setVisibility(8);
      this.qWV.setVisibility(8);
      this.qWW.setVisibility(8);
      this.qWM.setVisibility(0);
      this.mPa.setVisibility(0);
      this.qWT.setVisibility(0);
      this.qWS.setVisibility(0);
      this.qWU.setVisibility(0);
      AppMethodBeat.o(108319);
    }
    
    protected final int[] cEU()
    {
      AppMethodBeat.i(108320);
      int i = com.tencent.mm.cb.a.aG(this.mContext, 2131166277);
      AppMethodBeat.o(108320);
      return new int[] { i, i };
    }
    
    protected final int cEV()
    {
      AppMethodBeat.i(108321);
      int i = com.tencent.mm.cb.a.aG(this.mContext, 2131166276);
      AppMethodBeat.o(108321);
      return i;
    }
    
    protected final boolean cFe()
    {
      AppMethodBeat.i(108322);
      boolean bool = f.a(f.this);
      AppMethodBeat.o(108322);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.f
 * JD-Core Version:    0.7.0.1
 */