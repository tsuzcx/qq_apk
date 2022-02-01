package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.o;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;
import java.util.List;

public class f
  extends com.tencent.mm.plugin.emoji.a.a.a
{
  private final String TAG;
  public boolean otS;
  public boolean otT;
  public boolean otU;
  public boolean otV;
  private List<String> otW;
  
  public f(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(179051);
    this.TAG = "MicroMsg.emoji.EmojiStoreMainAdapter";
    this.otS = false;
    this.otT = true;
    this.otU = false;
    this.otV = true;
    this.otW = new LinkedList();
    AppMethodBeat.o(179051);
  }
  
  public void Ap(int paramInt) {}
  
  public void Aq(int paramInt) {}
  
  public void Ar(int paramInt) {}
  
  public View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int j = 1;
    int i = 0;
    AppMethodBeat.i(108325);
    a locala = (a)paramView.getTag();
    paramViewGroup = As(paramInt);
    if (this.otU)
    {
      paramViewGroup.ouR = true;
      paramViewGroup.ouP = false;
      paramViewGroup.ouQ = false;
    }
    Object localObject;
    label131:
    boolean bool;
    if ((locala != null) && (paramViewGroup != null))
    {
      paramViewGroup.ouQ = this.otV;
      localObject = paramViewGroup.ouM;
      if (localObject != null) {
        break label278;
      }
      locala.Ao(0);
      paramInt = 0;
      if (paramInt == 0)
      {
        paramViewGroup = paramViewGroup.ouL;
        if (paramViewGroup != null)
        {
          locala.setTitle(paramViewGroup.PackName);
          if (!com.tencent.mm.plugin.emoji.h.a.g(paramViewGroup)) {
            break label401;
          }
          o.ayJ().loadImage("", locala.bUd());
          locala.bUe();
          bool = com.tencent.mm.plugin.emoji.a.a.e.fd(paramViewGroup.PackType, 2);
          if (TextUtils.isEmpty(paramViewGroup.TagUri)) {
            break label430;
          }
          locala.bUf().setImageDrawable(null);
          locala.bUf().setVisibility(0);
          o.ayJ().a(paramViewGroup.TagUri, locala.bUf(), com.tencent.mm.plugin.emoji.e.e.eX("", paramViewGroup.TagUri));
          label193:
          localObject = locala.otn;
          if (!this.otW.contains(paramViewGroup.ProductID)) {
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
      locala.Tn(paramViewGroup);
      if ((this.otS) && (locala.otk != null)) {
        locala.otk.setBackgroundResource(2131231820);
      }
      AppMethodBeat.o(108325);
      return paramView;
      locala.setTitle(((EmotionBannerSet)localObject).Title);
      locala.Tn(((EmotionBannerSet)localObject).Desc);
      if (!bt.isNullOrNil(((EmotionBannerSet)localObject).IconUrl)) {
        o.ayJ().a(((EmotionBannerSet)localObject).IconUrl, locala.bUd(), com.tencent.mm.plugin.emoji.e.e.eX("", ((EmotionBannerSet)localObject).IconUrl));
      }
      if (!bt.isNullOrNil(((EmotionBannerSet)localObject).TagUrl))
      {
        o.ayJ().a(((EmotionBannerSet)localObject).TagUrl, locala.bUf(), com.tencent.mm.plugin.emoji.e.e.eX("", ((EmotionBannerSet)localObject).TagUrl));
        locala.An(0);
      }
      for (;;)
      {
        locala.Ao(8);
        paramInt = j;
        break;
        locala.An(8);
      }
      o.ayJ().a(paramViewGroup.IconUrl, locala.bUd(), com.tencent.mm.plugin.emoji.e.e.eX(paramViewGroup.ProductID, paramViewGroup.IconUrl));
      break label131;
      if (bool)
      {
        locala.An(0);
        locala.bUg();
        break label193;
      }
      locala.An(8);
      break label193;
      paramInt = 8;
      break label219;
    }
  }
  
  public int bUr()
  {
    return 0;
  }
  
  public int bUs()
  {
    return 0;
  }
  
  public int bUt()
  {
    return 0;
  }
  
  public final void cK(List<String> paramList)
  {
    AppMethodBeat.i(179052);
    this.otW.clear();
    if (paramList != null) {
      this.otW.addAll(paramList);
    }
    AppMethodBeat.o(179052);
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
    paramContext.a(this.ouA);
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
    
    protected final void bTZ()
    {
      AppMethodBeat.i(108319);
      this.otm.setVisibility(8);
      bUh();
      this.otq.setVisibility(8);
      this.otu.setVisibility(8);
      this.otv.setVisibility(8);
      this.otl.setVisibility(0);
      this.kEu.setVisibility(0);
      this.ots.setVisibility(0);
      this.otr.setVisibility(0);
      this.ott.setVisibility(0);
      AppMethodBeat.o(108319);
    }
    
    protected final int[] bUa()
    {
      AppMethodBeat.i(108320);
      int i = com.tencent.mm.cd.a.ao(this.mContext, 2131166234);
      AppMethodBeat.o(108320);
      return new int[] { i, i };
    }
    
    protected final int bUb()
    {
      AppMethodBeat.i(108321);
      int i = com.tencent.mm.cd.a.ao(this.mContext, 2131166233);
      AppMethodBeat.o(108321);
      return i;
    }
    
    protected final boolean bUk()
    {
      AppMethodBeat.i(108322);
      boolean bool = f.a(f.this);
      AppMethodBeat.o(108322);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.f
 * JD-Core Version:    0.7.0.1
 */