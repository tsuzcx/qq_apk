package com.tencent.mm.plugin.emoji.a;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ee;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.emoji.a.a.d;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.h.b;
import com.tencent.mm.plugin.emoji.h.c;
import com.tencent.mm.plugin.emoji.h.d;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.emoji.mgr.e;
import com.tencent.mm.plugin.emoji.model.m;
import com.tencent.mm.plugin.emoji.model.r.a;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
  extends com.tencent.mm.plugin.emoji.a.a.a
{
  private final String TAG = "MicroMsg.emoji.EmojiMineAdapter";
  private ProgressDialog pNH;
  
  public c(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void JZ(int paramInt) {}
  
  public final void Ka(int paramInt) {}
  
  public final void Kb(int paramInt) {}
  
  public final com.tencent.mm.plugin.emoji.a.a.c a(m paramm)
  {
    AppMethodBeat.i(108306);
    paramm = new d(paramm);
    AppMethodBeat.o(108306);
    return paramm;
  }
  
  public final View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(108304);
    paramViewGroup = (a)paramView.getTag();
    Object localObject = Kd(paramInt);
    if ((paramViewGroup != null) && (localObject != null))
    {
      localObject = ((f)localObject).xHE;
      if (localObject != null)
      {
        if (!com.tencent.mm.plugin.emoji.g.c.i((cjb)localObject)) {
          break label70;
        }
        paramViewGroup.setTitle(h.h.emoji_store_tuzi_title);
        paramViewGroup.JV(h.d.icon_002_cover);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(108304);
      return paramView;
      label70:
      if (!Util.isNullOrNil(((cjb)localObject).Zul)) {
        paramViewGroup.setTitle(((cjb)localObject).Zul);
      }
      for (;;)
      {
        if (Util.isNullOrNil(((cjb)localObject).IHo)) {
          break label144;
        }
        r.bKe().a(((cjb)localObject).IHo, paramViewGroup.dxW(), e.gJ(((cjb)localObject).ProductID, ((cjb)localObject).IHo));
        break;
        paramViewGroup.setTitle(((cjb)localObject).ProductID);
      }
      label144:
      Log.i("MicroMsg.emoji.EmojiMineAdapter", "Icon rul is null");
      paramViewGroup.dxW().setImageDrawable(null);
    }
  }
  
  public final void clear()
  {
    AppMethodBeat.i(108308);
    if (this.pNH != null) {
      this.pNH.cancel();
    }
    super.clear();
    AppMethodBeat.o(108308);
  }
  
  public final a d(Context paramContext, View paramView)
  {
    AppMethodBeat.i(108305);
    paramContext = new a(paramContext, paramView);
    paramContext.a(this.xHs);
    AppMethodBeat.o(108305);
    return paramContext;
  }
  
  public final void dX(String paramString, int paramInt)
  {
    AppMethodBeat.i(108307);
    if (paramInt == 7) {
      super.dX(paramString, paramInt);
    }
    AppMethodBeat.o(108307);
  }
  
  public final void dyg()
  {
    AppMethodBeat.i(108309);
    super.dyg();
    AppMethodBeat.o(108309);
  }
  
  public final int dyh()
  {
    return 0;
  }
  
  public final int dyi()
  {
    return 0;
  }
  
  public final int dyj()
  {
    return 0;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(108303);
    if (this.xHr == null) {
      this.xHr = a(null);
    }
    super.notifyDataSetChanged();
    AppMethodBeat.o(108303);
  }
  
  public final class a
    extends a
  {
    public a(Context paramContext, View paramView)
    {
      super(paramView);
    }
    
    protected final boolean a(r.a parama, View paramView)
    {
      AppMethodBeat.i(108299);
      dxZ();
      boolean bool = super.a(parama, paramView);
      AppMethodBeat.o(108299);
      return bool;
    }
    
    protected final void b(r.a parama, View paramView)
    {
      AppMethodBeat.i(108300);
      super.b(parama, paramView);
      if (com.tencent.mm.plugin.emoji.g.c.apa(getProductId()))
      {
        parama = new ee();
        parama.hDW.productId = getProductId();
        paramView = parama.hDW;
        if (!com.tencent.mm.plugin.emoji.g.c.dBJ()) {
          break label95;
        }
      }
      label95:
      for (int i = 7;; i = 3)
      {
        paramView.status = i;
        parama.hDW.progress = getProgress();
        parama.hDW.hDX = this.xFY.xHI;
        parama.publish();
        AppMethodBeat.o(108300);
        return;
      }
    }
    
    protected final void dxT()
    {
      AppMethodBeat.i(108298);
      this.xGb.setVisibility(8);
      this.xGc.setVisibility(8);
      dxY();
      this.xGi.setVisibility(8);
      this.xGm.setVisibility(8);
      this.xGn.setVisibility(8);
      this.xGa.setVisibility(0);
      this.sUt.setVisibility(0);
      this.xGk.setVisibility(0);
      this.xGj.setVisibility(0);
      this.xGl.setVisibility(0);
      AppMethodBeat.o(108298);
    }
    
    protected final int[] dxU()
    {
      AppMethodBeat.i(108301);
      int i = getContext().getResources().getDimensionPixelSize(h.c.BigIconSize);
      AppMethodBeat.o(108301);
      return new int[] { i, i };
    }
    
    protected final int dxV()
    {
      return -1;
    }
    
    protected final boolean dyb()
    {
      return true;
    }
    
    public final void dye()
    {
      AppMethodBeat.i(108302);
      if (this.xFY == null)
      {
        AppMethodBeat.o(108302);
        return;
      }
      switch (dxZ())
      {
      default: 
        this.xGi.setVisibility(8);
        this.xGj.setBackgroundResource(h.d.btn_solid_white);
        this.xGj.setVisibility(0);
        this.xGl.setVisibility(0);
        this.xGl.setText(h.h.emoji_store_uninstall_emoji);
        this.xGl.setTextColor(getContext().getResources().getColorStateList(h.b.black_text_color_selector));
        this.xGm.setVisibility(4);
        this.xGm.setImageResource(h.d.emoji_download);
        this.xGn.setVisibility(4);
        AppMethodBeat.o(108302);
        return;
      case 0: 
      case 3: 
        this.xGi.setVisibility(8);
        this.xGj.setBackgroundResource(h.d.btn_solid_green);
        this.xGj.setVisibility(0);
        this.xGl.setVisibility(0);
        this.xGl.setText(h.h.emoji_store_download);
        this.xGl.setTextColor(getContext().getResources().getColorStateList(h.b.white_text_color_selector));
        this.xGm.setVisibility(4);
        this.xGm.setImageResource(h.d.emoji_download);
        this.xGn.setVisibility(4);
        AppMethodBeat.o(108302);
        return;
      }
      dyc();
      AppMethodBeat.o(108302);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.c
 * JD-Core Version:    0.7.0.1
 */