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
import com.tencent.mm.ay.q;
import com.tencent.mm.f.a.du;
import com.tencent.mm.plugin.emoji.a.a.d;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.e.e;
import com.tencent.mm.plugin.emoji.i.b;
import com.tencent.mm.plugin.emoji.i.c;
import com.tencent.mm.plugin.emoji.i.d;
import com.tencent.mm.plugin.emoji.i.h;
import com.tencent.mm.plugin.emoji.model.l;
import com.tencent.mm.plugin.emoji.model.o.a;
import com.tencent.mm.protocal.protobuf.akh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class c
  extends com.tencent.mm.plugin.emoji.a.a.a
{
  private final String TAG = "MicroMsg.emoji.EmojiMineAdapter";
  private ProgressDialog mRa;
  
  public c(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void Js(int paramInt) {}
  
  public final void Jt(int paramInt) {}
  
  public final void Ju(int paramInt) {}
  
  public final com.tencent.mm.plugin.emoji.a.a.c a(l paraml)
  {
    AppMethodBeat.i(108306);
    paraml = new d(paraml);
    AppMethodBeat.o(108306);
    return paraml;
  }
  
  public final View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(108304);
    paramViewGroup = (a)paramView.getTag();
    Object localObject = Jv(paramInt);
    if ((paramViewGroup != null) && (localObject != null))
    {
      localObject = ((f)localObject).uBa;
      if (localObject != null)
      {
        if (!com.tencent.mm.plugin.emoji.i.a.g((akh)localObject)) {
          break label90;
        }
        paramViewGroup.setTitle(i.h.emoji_store_tuzi_title);
        paramViewGroup.Jo(i.d.icon_002_cover);
      }
    }
    for (;;)
    {
      if (paramInt + 1 == getCount()) {
        paramViewGroup.uzz.setBackgroundResource(i.d.comm_list_item_selector_no_divider);
      }
      AppMethodBeat.o(108304);
      return paramView;
      label90:
      if (!Util.isNullOrNil(((akh)localObject).Suv)) {
        paramViewGroup.setTitle(((akh)localObject).Suv);
      }
      for (;;)
      {
        if (Util.isNullOrNil(((akh)localObject).CNj)) {
          break label164;
        }
        q.bml().a(((akh)localObject).CNj, paramViewGroup.cTB(), e.gd(((akh)localObject).ProductID, ((akh)localObject).CNj));
        break;
        paramViewGroup.setTitle(((akh)localObject).ProductID);
      }
      label164:
      Log.i("MicroMsg.emoji.EmojiMineAdapter", "Icon rul is null");
      paramViewGroup.cTB().setImageDrawable(null);
    }
  }
  
  public final void cTL()
  {
    AppMethodBeat.i(108309);
    super.cTL();
    AppMethodBeat.o(108309);
  }
  
  public final int cTM()
  {
    return 0;
  }
  
  public final int cTN()
  {
    return 0;
  }
  
  public final int cTO()
  {
    return 0;
  }
  
  public final void clear()
  {
    AppMethodBeat.i(108308);
    if (this.mRa != null) {
      this.mRa.cancel();
    }
    super.clear();
    AppMethodBeat.o(108308);
  }
  
  public final a d(Context paramContext, View paramView)
  {
    AppMethodBeat.i(108305);
    paramContext = new a(paramContext, paramView);
    paramContext.a(this.uAP);
    AppMethodBeat.o(108305);
    return paramContext;
  }
  
  public final void dw(String paramString, int paramInt)
  {
    AppMethodBeat.i(108307);
    if (paramInt == 7) {
      super.dw(paramString, paramInt);
    }
    AppMethodBeat.o(108307);
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(108303);
    if (this.uAO == null) {
      this.uAO = a(null);
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
    
    protected final boolean a(o.a parama, View paramView)
    {
      AppMethodBeat.i(108299);
      cTE();
      boolean bool = super.a(parama, paramView);
      AppMethodBeat.o(108299);
      return bool;
    }
    
    protected final void b(o.a parama, View paramView)
    {
      AppMethodBeat.i(108300);
      super.b(parama, paramView);
      if (com.tencent.mm.plugin.emoji.i.a.ava(getProductId()))
      {
        parama = new du();
        parama.fzn.productId = getProductId();
        paramView = parama.fzn;
        if (!com.tencent.mm.plugin.emoji.i.a.cWg()) {
          break label98;
        }
      }
      label98:
      for (int i = 7;; i = 3)
      {
        paramView.status = i;
        parama.fzn.progress = getProgress();
        parama.fzn.fzo = this.uzy.uBd;
        EventCenter.instance.publish(parama);
        AppMethodBeat.o(108300);
        return;
      }
    }
    
    protected final int cTA()
    {
      return -1;
    }
    
    protected final boolean cTG()
    {
      return true;
    }
    
    public final void cTJ()
    {
      AppMethodBeat.i(108302);
      if (this.uzy == null)
      {
        AppMethodBeat.o(108302);
        return;
      }
      switch (cTE())
      {
      default: 
        this.uzF.setVisibility(8);
        this.uzG.setBackgroundResource(i.d.btn_solid_white);
        this.uzG.setVisibility(0);
        this.uzI.setVisibility(0);
        this.uzI.setText(i.h.emoji_store_uninstall_emoji);
        this.uzI.setTextColor(getContext().getResources().getColorStateList(i.b.black_text_color_selector));
        this.uzJ.setVisibility(4);
        this.uzJ.setImageResource(i.d.emoji_download);
        this.uzK.setVisibility(4);
        AppMethodBeat.o(108302);
        return;
      case 0: 
      case 3: 
        this.uzF.setVisibility(8);
        this.uzG.setBackgroundResource(i.d.btn_solid_green);
        this.uzG.setVisibility(0);
        this.uzI.setVisibility(0);
        this.uzI.setText(i.h.emoji_store_download);
        this.uzI.setTextColor(getContext().getResources().getColorStateList(i.b.white_text_color_selector));
        this.uzJ.setVisibility(4);
        this.uzJ.setImageResource(i.d.emoji_download);
        this.uzK.setVisibility(4);
        AppMethodBeat.o(108302);
        return;
      }
      cTH();
      AppMethodBeat.o(108302);
    }
    
    protected final void cTy()
    {
      AppMethodBeat.i(108298);
      this.uzB.setVisibility(8);
      this.uzC.setVisibility(8);
      cTD();
      this.uzF.setVisibility(8);
      this.uzJ.setVisibility(8);
      this.uzK.setVisibility(8);
      this.uzA.setVisibility(0);
      this.pPT.setVisibility(0);
      this.uzH.setVisibility(0);
      this.uzG.setVisibility(0);
      this.uzI.setVisibility(0);
      AppMethodBeat.o(108298);
    }
    
    protected final int[] cTz()
    {
      AppMethodBeat.i(108301);
      int i = getContext().getResources().getDimensionPixelSize(i.c.BigIconSize);
      AppMethodBeat.o(108301);
      return new int[] { i, i };
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.c
 * JD-Core Version:    0.7.0.1
 */