package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.as.o;
import com.tencent.mm.plugin.emoji.f.d;
import com.tencent.mm.protocal.c.ve;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.sdk.platformtools.bk;

public class f
  extends com.tencent.mm.plugin.emoji.a.a.a
{
  private final String TAG = "MicroMsg.emoji.EmojiStoreMainAdapter";
  public boolean iVe = false;
  public boolean iVf = true;
  public boolean iVg = false;
  public boolean iVh = true;
  
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  public int aGQ()
  {
    return 0;
  }
  
  public int aGR()
  {
    return 0;
  }
  
  public int aGS()
  {
    return 0;
  }
  
  protected boolean aGU()
  {
    return false;
  }
  
  public View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 1;
    f.a locala = (f.a)paramView.getTag();
    paramViewGroup = pP(paramInt);
    if (this.iVg)
    {
      paramViewGroup.iWa = true;
      paramViewGroup.iVY = false;
      paramViewGroup.iVZ = false;
    }
    ve localve;
    label126:
    boolean bool;
    if ((locala != null) && (paramViewGroup != null))
    {
      paramViewGroup.iVZ = this.iVh;
      localve = paramViewGroup.iVV;
      if (localve != null) {
        break label234;
      }
      locala.pL(0);
      paramInt = 0;
      if (paramInt == 0)
      {
        paramViewGroup = paramViewGroup.iVU;
        if (paramViewGroup != null)
        {
          locala.setTitle(paramViewGroup.sSc);
          if (!com.tencent.mm.plugin.emoji.h.a.d(paramViewGroup)) {
            break label357;
          }
          o.ON().a("", locala.aGE());
          locala.pI(f.d.icon_002_cover);
          bool = com.tencent.mm.plugin.emoji.a.a.e.cC(paramViewGroup.sSg, 2);
          if (TextUtils.isEmpty(paramViewGroup.sSN)) {
            break label386;
          }
          locala.aGF().setImageDrawable(null);
          locala.aGF().setVisibility(0);
          o.ON().a(paramViewGroup.sSN, locala.aGF(), com.tencent.mm.plugin.emoji.e.e.cJ("", paramViewGroup.sSN));
          label188:
          if (!aGU()) {
            break label418;
          }
        }
      }
    }
    label386:
    label418:
    for (paramViewGroup = paramViewGroup.sSO;; paramViewGroup = paramViewGroup.sSM)
    {
      locala.Aj(paramViewGroup);
      if ((this.iVe) && (locala.iUw != null)) {
        locala.iUw.setBackgroundResource(f.d.comm_list_item_selector_no_divider);
      }
      return paramView;
      label234:
      locala.setTitle(localve.bGw);
      locala.Aj(localve.kRN);
      if (!bk.bl(localve.kSy)) {
        o.ON().a(localve.kSy, locala.aGE(), com.tencent.mm.plugin.emoji.e.e.cJ("", localve.kSy));
      }
      if (!bk.bl(localve.sRW))
      {
        o.ON().a(localve.sRW, locala.aGF(), com.tencent.mm.plugin.emoji.e.e.cJ("", localve.sRW));
        locala.pJ(0);
      }
      for (;;)
      {
        locala.pL(8);
        paramInt = i;
        break;
        locala.pJ(8);
      }
      label357:
      o.ON().a(paramViewGroup.kSy, locala.aGE(), com.tencent.mm.plugin.emoji.e.e.cJ(paramViewGroup.syc, paramViewGroup.kSy));
      break label126;
      if (bool)
      {
        locala.pJ(0);
        locala.pK(f.d.emotionstore_newtips);
        break label188;
      }
      locala.pJ(8);
      break label188;
    }
  }
  
  protected final a c(Context paramContext, View paramView)
  {
    paramContext = new f.a(this, paramContext, paramView);
    paramContext.a(this.iVJ);
    return paramContext;
  }
  
  public final void clear()
  {
    super.clear();
  }
  
  public void pM(int paramInt) {}
  
  public void pN(int paramInt) {}
  
  public void pO(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.f
 * JD-Core Version:    0.7.0.1
 */