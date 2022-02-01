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
import com.tencent.mm.sdk.platformtools.ac;

public abstract class d
  extends a
{
  public static float oOZ = Resources.getSystem().getDisplayMetrics().density;
  public static int oPa = Resources.getSystem().getDisplayMetrics().widthPixels;
  public static int oPb = (int)(40.0F * oOZ + 0.5F);
  public ImageView dhf;
  public LinearLayout iRV;
  public WXRTEditText oOL;
  public WXRTEditText oOM;
  public LinearLayout oON;
  public TextView oOO;
  public TextView oOP;
  public ImageView oOQ;
  public View oOR;
  public LinearLayout oOS;
  public LinearLayout oOT;
  public LinearLayout oOU;
  public LinearLayout oOV;
  public LinearLayout oOW;
  public LinearLayout oOX;
  public LinearLayout oOY;
  public View.OnClickListener oPc = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(181651);
      d.this.oOb.oSf.bZb().bYR();
      AppMethodBeat.o(181651);
    }
  };
  
  public d(View paramView, j paramj)
  {
    super(paramView, paramj);
    this.dhf = ((ImageView)paramView.findViewById(2131299257));
    this.oOR = paramView.findViewById(2131306315);
    this.oON = ((LinearLayout)paramView.findViewById(2131302917));
    this.iRV = ((LinearLayout)paramView.findViewById(2131302943));
    this.oOO = ((TextView)paramView.findViewById(2131302918));
    this.oOP = ((TextView)paramView.findViewById(2131302915));
    this.oOQ = ((ImageView)paramView.findViewById(2131302916));
    this.oOO.setTextSize(16.0F);
    this.oOP.setTextSize(12.0F);
    this.oOS = ((LinearLayout)paramView.findViewById(2131302941));
    this.oOS.setVisibility(8);
    this.oOU = ((LinearLayout)paramView.findViewById(2131302936));
    this.oOU.setVisibility(8);
    this.oOV = ((LinearLayout)paramView.findViewById(2131302914));
    this.oOV.setVisibility(8);
    this.oOW = ((LinearLayout)paramView.findViewById(2131303103));
    this.oOW.setBackgroundColor(1347529272);
    this.oOW.setVisibility(8);
    this.oOW.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181648);
        e.cal().caq();
        AppMethodBeat.o(181648);
      }
    });
    this.oOX = ((LinearLayout)paramView.findViewById(2131303110));
    this.oOX.setBackgroundColor(1347529272);
    this.oOX.setVisibility(4);
    this.oOY = ((LinearLayout)paramView.findViewById(2131303105));
    this.oOY.setBackgroundColor(1347529272);
    this.oOY.setVisibility(4);
    this.oOT = ((LinearLayout)paramView.findViewById(2131299269));
    paramj = (RelativeLayout.LayoutParams)this.oOT.getLayoutParams();
    paramj.width = (oPa - oPb);
    paramj.height = -2;
    this.oOT.setLayoutParams(paramj);
    this.oOM = ((WXRTEditText)paramView.findViewById(2131297578));
    this.oOL = ((WXRTEditText)paramView.findViewById(2131297580));
    ((LinearLayout)paramView.findViewById(2131297579)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181649);
        d.this.oOM.bZW();
        d.this.oOM.requestFocus();
        AppMethodBeat.o(181649);
      }
    });
    ((LinearLayout)paramView.findViewById(2131297581)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181650);
        d.this.oOL.bZW();
        d.this.oOL.requestFocus();
        AppMethodBeat.o(181650);
      }
    });
    this.oOM.setEditTextType(2);
    this.oOL.setEditTextType(1);
    this.oOL.oRB = this;
    this.oOM.oRB = this;
    if (!this.oOb.oSl)
    {
      this.oOM.setKeyListener(null);
      this.oOM.setEnabled(false);
      this.oOM.setFocusable(false);
      this.oOL.setKeyListener(null);
      this.oOL.setEnabled(false);
      this.oOL.setFocusable(false);
    }
    this.oOb.q(this.oOL);
    this.oOb.q(this.oOM);
  }
  
  public void a(com.tencent.mm.plugin.editor.model.a.a parama, int paramInt1, int paramInt2)
  {
    ac.i("MicroMsg.EditorOtherItemHolder", "ImageItemHolder position is " + lu());
    this.oOL.setPosInDataList(paramInt1);
    this.oOM.setPosInDataList(paramInt1);
    if (e.isEnabled()) {
      e.cal().a(this.oOW, this.oOX, this.oOY, paramInt1);
    }
    parama.oPY = this.oOL;
    parama.oPZ = this.oOM;
    parama.oQa = null;
    if (parama.oPV) {
      if (parama.oQb) {
        this.oOL.requestFocus();
      }
    }
    for (;;)
    {
      if (this.oON.getVisibility() == 0)
      {
        if (!parama.oQc) {
          break;
        }
        this.oON.setBackgroundResource(2131231974);
      }
      return;
      this.oOM.requestFocus();
      continue;
      if (this.oOL.hasFocus()) {
        this.oOL.clearFocus();
      }
      if (this.oOM.hasFocus()) {
        this.oOM.clearFocus();
      }
    }
    this.oON.setBackgroundResource(2131231973);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.d
 * JD-Core Version:    0.7.0.1
 */