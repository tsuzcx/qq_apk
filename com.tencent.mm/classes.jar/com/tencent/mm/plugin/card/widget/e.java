package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.a.c;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.card.a.b;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.c.n;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.ui.CardDetailUI.a;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.LinkedList;

public final class e
  extends a
{
  protected TextView pJJ;
  private RelativeLayout wLr;
  private TextView wLs;
  private View wLt;
  private ImageView wLu;
  private ImageView wLv;
  private ImageView wLw;
  private ImageView wLx;
  private ImageView wLy;
  private LinearLayout wxi;
  
  public e(Context paramContext)
  {
    super(paramContext);
  }
  
  private void dpa()
  {
    AppMethodBeat.i(113912);
    Object localObject = new c.a();
    ((c.a)localObject).prefixPath = com.tencent.mm.loader.i.b.bmz();
    ((c.a)localObject).oKH = r.bKf();
    ((c.a)localObject).fullPath = m.akH(this.wru.djL().ZbJ);
    ((c.a)localObject).oKp = true;
    ((c.a)localObject).nrc = true;
    ((c.a)localObject).oKI = this.mContext.getResources().getDimensionPixelSize(a.b.wdY);
    ((c.a)localObject).oKJ = true;
    ((c.a)localObject).oKn = true;
    ((c.a)localObject).oKB = a.c.weC;
    ((c.a)localObject).npV = com.tencent.mm.cd.a.br(this.mContext, a.b.wea);
    ((c.a)localObject).npU = com.tencent.mm.cd.a.ms(this.mContext);
    localObject = ((c.a)localObject).bKx();
    r.bKe().a(this.wru.djL().ZbJ, this.wLx, (c)localObject);
    Log.i("MicroMsg.CardWidgetMembership", "the member back ground url is " + this.wru.djL().ZbJ);
    AppMethodBeat.o(113912);
  }
  
  public final void IO(int paramInt)
  {
    AppMethodBeat.i(113909);
    if (!TextUtils.isEmpty(this.wru.djL().ZbJ))
    {
      this.wLx.setBackgroundDrawable(null);
      this.wLy.setVisibility(0);
      dpa();
      AppMethodBeat.o(113909);
      return;
    }
    if (this.wKN != null)
    {
      this.wLx.setBackgroundResource(paramInt);
      this.wLy.setVisibility(8);
    }
    AppMethodBeat.o(113909);
  }
  
  public final void P(boolean paramBoolean1, boolean paramBoolean2) {}
  
  public final void a(ShapeDrawable paramShapeDrawable)
  {
    AppMethodBeat.i(113910);
    if (!TextUtils.isEmpty(this.wru.djL().ZbJ))
    {
      this.wLx.setBackgroundDrawable(null);
      this.wLy.setVisibility(0);
      dpa();
      AppMethodBeat.o(113910);
      return;
    }
    if (this.wKN != null)
    {
      this.wLx.setBackgroundDrawable(paramShapeDrawable);
      this.wLy.setVisibility(8);
    }
    AppMethodBeat.o(113910);
  }
  
  protected final void doX()
  {
    AppMethodBeat.i(113906);
    this.pJJ = ((TextView)doW().findViewById(a.d.fvy));
    this.wLr = ((RelativeLayout)doW().findViewById(a.d.whg));
    this.wxi = ((LinearLayout)doW().findViewById(a.d.wfO));
    this.wLs = ((TextView)doW().findViewById(a.d.wjG));
    this.wLt = doW().findViewById(a.d.wfM);
    this.wLu = ((ImageView)doW().findViewById(a.d.wfN));
    this.wLv = ((ImageView)this.wKN.findViewById(a.d.wkC));
    this.wLw = ((ImageView)this.wKN.findViewById(a.d.wkB));
    this.wLx = ((ImageView)this.wKN.findViewById(a.d.whd));
    this.wLy = ((ImageView)this.wKN.findViewById(a.d.whf));
    AppMethodBeat.o(113906);
  }
  
  protected final void doY()
  {
    AppMethodBeat.i(113907);
    if (this.uov != null) {
      this.uov.setText(this.wru.djK().mee);
    }
    Object localObject;
    if ((this.wru.djK().ZdK != null) && (this.wru.djK().ZdK.size() > 0))
    {
      localObject = (aek)this.wru.djK().ZdK.get(0);
      if (!TextUtils.isEmpty(((aek)localObject).title)) {
        this.pJJ.setText(((aek)localObject).title);
      }
    }
    else
    {
      if (!this.wru.djF()) {
        break label524;
      }
      nk(true);
      this.wLx.setAlpha(255);
      if (this.wLx.getBackground() != null) {
        this.wLx.getBackground().setAlpha(255);
      }
      localObject = this.wru.djL().code;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        break label329;
      }
      Log.e("MicroMsg.CardWidgetMembership", "don't updateCodeLayout, code is empty!");
      nk(false);
      ((CardDetailUI.a)((MMActivity)this.mContext).component(CardDetailUI.a.class)).ne(false);
    }
    for (;;)
    {
      localObject = this.wLr.getLayoutParams();
      int i = this.mContext.getResources().getDimensionPixelSize(a.b.LargerPadding);
      int j = this.mContext.getResources().getDisplayMetrics().widthPixels - i * 2;
      int k = j * 3 / 5;
      ((ViewGroup.LayoutParams)localObject).height = k;
      Log.d("MicroMsg.CardWidgetMembership", "padding:%d,originWidth:%d,targetWidth:%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k) });
      this.wLr.setLayoutParams((ViewGroup.LayoutParams)localObject);
      AppMethodBeat.o(113907);
      return;
      this.pJJ.setText("");
      break;
      label329:
      this.wLt.setOnClickListener(this.qjL);
      this.wLu.setOnClickListener(this.qjL);
      this.wLs.setOnClickListener(this.qjL);
      ((CardDetailUI.a)((MMActivity)this.mContext).component(CardDetailUI.a.class)).ne(true);
      switch (this.wru.djL().Zby)
      {
      default: 
        break;
      case 0: 
        if (((String)localObject).length() <= 40) {
          this.wLs.setText(n.alC((String)localObject));
        }
        break;
      case 1: 
      case 2: 
        if (((String)localObject).length() <= 40)
        {
          if (this.wru.djy()) {
            this.wLs.setText(n.alC((String)localObject));
          } else {
            this.wLs.setText("");
          }
        }
        else
        {
          this.wLs.setText("");
          continue;
          this.wLs.setText("");
          continue;
          label524:
          this.wLs.setText("");
          this.wLu.setVisibility(8);
          this.wLt.setVisibility(8);
          this.wLx.setAlpha(90);
          if (this.wLx.getBackground() != null) {
            this.wLx.getBackground().setAlpha(90);
          }
        }
        break;
      }
    }
  }
  
  public final void nk(boolean paramBoolean)
  {
    AppMethodBeat.i(113908);
    if ((!TextUtils.isEmpty(this.wru.djL().code)) && (paramBoolean) && (this.wru.djL().Zby != 0) && (!this.wru.djK().Zer))
    {
      this.wLu.setVisibility(0);
      this.wLt.setVisibility(0);
      AppMethodBeat.o(113908);
      return;
    }
    this.wLu.setVisibility(8);
    this.wLt.setVisibility(8);
    AppMethodBeat.o(113908);
  }
  
  public final void nl(boolean paramBoolean)
  {
    AppMethodBeat.i(113911);
    if (!TextUtils.isEmpty(this.wru.djL().ZbJ))
    {
      this.wLw.setVisibility(8);
      this.wLv.setVisibility(8);
      AppMethodBeat.o(113911);
      return;
    }
    this.wLw.setVisibility(0);
    this.wLv.setVisibility(0);
    AppMethodBeat.o(113911);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.e
 * JD-Core Version:    0.7.0.1
 */