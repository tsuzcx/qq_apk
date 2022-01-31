package com.tencent.mm.plugin.emoji.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mm.as.o;
import com.tencent.mm.plugin.emoji.a.a.d;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.f.d;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public final class c
  extends com.tencent.mm.plugin.emoji.a.a.a
{
  private final String TAG = "MicroMsg.emoji.EmojiMineAdapter";
  private ProgressDialog faz;
  
  public c(Context paramContext)
  {
    super(paramContext);
  }
  
  protected final com.tencent.mm.plugin.emoji.a.a.c a(com.tencent.mm.plugin.emoji.model.f paramf)
  {
    return new d(paramf);
  }
  
  protected final void aGP()
  {
    super.aGP();
  }
  
  public final int aGQ()
  {
    return 0;
  }
  
  public final int aGR()
  {
    return 0;
  }
  
  public final int aGS()
  {
    return 0;
  }
  
  public final View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramViewGroup = (c.a)paramView.getTag();
    Object localObject = pP(paramInt);
    if ((paramViewGroup != null) && (localObject != null))
    {
      localObject = ((com.tencent.mm.plugin.emoji.a.a.f)localObject).iVU;
      if (localObject != null)
      {
        if (!com.tencent.mm.plugin.emoji.h.a.d((vn)localObject)) {
          break label80;
        }
        paramViewGroup.setTitle(f.h.emoji_store_tuzi_title);
        paramViewGroup.pI(f.d.icon_002_cover);
      }
    }
    while (paramInt + 1 == getCount())
    {
      paramViewGroup.iUw.setBackgroundResource(f.d.comm_list_item_selector_no_divider);
      return paramView;
      label80:
      if (!bk.bl(((vn)localObject).sSc)) {
        paramViewGroup.setTitle(((vn)localObject).sSc);
      }
      for (;;)
      {
        if (bk.bl(((vn)localObject).kSy)) {
          break label154;
        }
        o.ON().a(((vn)localObject).kSy, paramViewGroup.aGE(), e.cJ(((vn)localObject).syc, ((vn)localObject).kSy));
        break;
        paramViewGroup.setTitle(((vn)localObject).syc);
      }
      label154:
      y.i("MicroMsg.emoji.EmojiMineAdapter", "Icon rul is null");
      paramViewGroup.aGE().setImageDrawable(null);
    }
    paramViewGroup.iUw.setBackgroundResource(f.d.comm_list_item_selector);
    return paramView;
  }
  
  public final void bt(String paramString, int paramInt)
  {
    if (paramInt == 7) {
      super.bt(paramString, paramInt);
    }
  }
  
  protected final a c(Context paramContext, View paramView)
  {
    paramContext = new c.a(this, paramContext, paramView);
    paramContext.a(this.iVJ);
    return paramContext;
  }
  
  public final void clear()
  {
    if (this.faz != null) {
      this.faz.cancel();
    }
    super.clear();
  }
  
  public final void notifyDataSetChanged()
  {
    if (this.iVI == null) {
      this.iVI = a(null);
    }
    super.notifyDataSetChanged();
  }
  
  public final void pM(int paramInt) {}
  
  public final void pN(int paramInt) {}
  
  public final void pO(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.c
 * JD-Core Version:    0.7.0.1
 */