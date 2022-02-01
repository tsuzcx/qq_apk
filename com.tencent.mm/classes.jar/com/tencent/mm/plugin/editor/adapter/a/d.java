package com.tencent.mm.plugin.editor.adapter.a;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.editor.model.nativenote.c.e;
import com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.editor.model.nativenote.manager.j;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class d
  extends a
{
  public static int olA = Resources.getSystem().getDisplayMetrics().widthPixels;
  public static int olB = (int)(40.0F * olz + 0.5F);
  public static float olz = Resources.getSystem().getDisplayMetrics().density;
  public ImageView djK;
  public LinearLayout irQ;
  public View.OnClickListener olC = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(181651);
      d.this.okB.ooF.bRM().bRC();
      AppMethodBeat.o(181651);
    }
  };
  public WXRTEditText oll;
  public WXRTEditText olm;
  public LinearLayout oln;
  public TextView olo;
  public TextView olp;
  public ImageView olq;
  public View olr;
  public LinearLayout ols;
  public LinearLayout olt;
  public LinearLayout olu;
  public LinearLayout olv;
  public LinearLayout olw;
  public LinearLayout olx;
  public LinearLayout oly;
  
  public d(View paramView, j paramj)
  {
    super(paramView, paramj);
    this.djK = ((ImageView)paramView.findViewById(2131299257));
    this.olr = paramView.findViewById(2131306315);
    this.oln = ((LinearLayout)paramView.findViewById(2131302917));
    this.irQ = ((LinearLayout)paramView.findViewById(2131302943));
    this.olo = ((TextView)paramView.findViewById(2131302918));
    this.olp = ((TextView)paramView.findViewById(2131302915));
    this.olq = ((ImageView)paramView.findViewById(2131302916));
    this.olo.setTextSize(16.0F);
    this.olp.setTextSize(12.0F);
    this.ols = ((LinearLayout)paramView.findViewById(2131302941));
    this.ols.setVisibility(8);
    this.olu = ((LinearLayout)paramView.findViewById(2131302936));
    this.olu.setVisibility(8);
    this.olv = ((LinearLayout)paramView.findViewById(2131302914));
    this.olv.setVisibility(8);
    this.olw = ((LinearLayout)paramView.findViewById(2131303103));
    this.olw.setBackgroundColor(1347529272);
    this.olw.setVisibility(8);
    this.olw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181648);
        e.bSW().bTb();
        AppMethodBeat.o(181648);
      }
    });
    this.olx = ((LinearLayout)paramView.findViewById(2131303110));
    this.olx.setBackgroundColor(1347529272);
    this.olx.setVisibility(4);
    this.oly = ((LinearLayout)paramView.findViewById(2131303105));
    this.oly.setBackgroundColor(1347529272);
    this.oly.setVisibility(4);
    this.olt = ((LinearLayout)paramView.findViewById(2131299269));
    paramj = (RelativeLayout.LayoutParams)this.olt.getLayoutParams();
    paramj.width = (olA - olB);
    paramj.height = -2;
    this.olt.setLayoutParams(paramj);
    this.olm = ((WXRTEditText)paramView.findViewById(2131297578));
    this.oll = ((WXRTEditText)paramView.findViewById(2131297580));
    ((LinearLayout)paramView.findViewById(2131297579)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181649);
        d.this.olm.bSH();
        d.this.olm.requestFocus();
        AppMethodBeat.o(181649);
      }
    });
    ((LinearLayout)paramView.findViewById(2131297581)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181650);
        d.this.oll.bSH();
        d.this.oll.requestFocus();
        AppMethodBeat.o(181650);
      }
    });
    this.olm.setEditTextType(2);
    this.oll.setEditTextType(1);
    this.oll.oob = this;
    this.olm.oob = this;
    if (!this.okB.ooL)
    {
      this.olm.setKeyListener(null);
      this.olm.setEnabled(false);
      this.olm.setFocusable(false);
      this.oll.setKeyListener(null);
      this.oll.setEnabled(false);
      this.oll.setFocusable(false);
    }
    this.okB.q(this.oll);
    this.okB.q(this.olm);
  }
  
  public void a(com.tencent.mm.plugin.editor.model.a.a parama, int paramInt1, int paramInt2)
  {
    ad.i("MicroMsg.EditorOtherItemHolder", "ImageItemHolder position is " + lm());
    this.oll.setPosInDataList(paramInt1);
    this.olm.setPosInDataList(paramInt1);
    if (e.isEnabled()) {
      e.bSW().a(this.olw, this.olx, this.oly, paramInt1);
    }
    parama.omy = this.oll;
    parama.omz = this.olm;
    parama.omA = null;
    if (parama.omv) {
      if (parama.omB) {
        this.oll.requestFocus();
      }
    }
    for (;;)
    {
      if (this.oln.getVisibility() == 0)
      {
        if (!parama.omC) {
          break;
        }
        this.oln.setBackgroundResource(2131231974);
      }
      return;
      this.olm.requestFocus();
      continue;
      if (this.oll.hasFocus()) {
        this.oll.clearFocus();
      }
      if (this.olm.hasFocus()) {
        this.olm.clearFocus();
      }
    }
    this.oln.setBackgroundResource(2131231973);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.d
 * JD-Core Version:    0.7.0.1
 */