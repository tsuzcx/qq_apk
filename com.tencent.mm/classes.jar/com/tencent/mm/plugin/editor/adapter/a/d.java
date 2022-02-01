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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.editor.model.nativenote.c.e;
import com.tencent.mm.plugin.editor.model.nativenote.manager.WXRTEditText;
import com.tencent.mm.plugin.editor.model.nativenote.manager.j;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class d
  extends a
{
  public static float psH = Resources.getSystem().getDisplayMetrics().density;
  public static int psI = Resources.getSystem().getDisplayMetrics().widthPixels;
  public static int psJ = (int)(40.0F * psH + 0.5F);
  public ImageView dsD;
  public LinearLayout jld;
  public LinearLayout psA;
  public LinearLayout psB;
  public LinearLayout psC;
  public LinearLayout psD;
  public LinearLayout psE;
  public LinearLayout psF;
  public LinearLayout psG;
  public View.OnClickListener psK = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(181651);
      b localb = new b();
      localb.bd(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      d.this.prJ.pvP.cdF().cdv();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(181651);
    }
  };
  public WXRTEditText pst;
  public WXRTEditText psu;
  public LinearLayout psv;
  public TextView psw;
  public TextView psx;
  public ImageView psy;
  public View psz;
  
  public d(View paramView, j paramj)
  {
    super(paramView, paramj);
    this.dsD = ((ImageView)paramView.findViewById(2131299257));
    this.psz = paramView.findViewById(2131306315);
    this.psv = ((LinearLayout)paramView.findViewById(2131302917));
    this.jld = ((LinearLayout)paramView.findViewById(2131302943));
    this.psw = ((TextView)paramView.findViewById(2131302918));
    this.psx = ((TextView)paramView.findViewById(2131302915));
    this.psy = ((ImageView)paramView.findViewById(2131302916));
    this.psw.setTextSize(16.0F);
    this.psx.setTextSize(12.0F);
    this.psA = ((LinearLayout)paramView.findViewById(2131302941));
    this.psA.setVisibility(8);
    this.psC = ((LinearLayout)paramView.findViewById(2131302936));
    this.psC.setVisibility(8);
    this.psD = ((LinearLayout)paramView.findViewById(2131302914));
    this.psD.setVisibility(8);
    this.psE = ((LinearLayout)paramView.findViewById(2131303103));
    this.psE.setBackgroundColor(1347529272);
    this.psE.setVisibility(8);
    this.psE.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181648);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        e.ceP().ceU();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(181648);
      }
    });
    this.psF = ((LinearLayout)paramView.findViewById(2131303110));
    this.psF.setBackgroundColor(1347529272);
    this.psF.setVisibility(4);
    this.psG = ((LinearLayout)paramView.findViewById(2131303105));
    this.psG.setBackgroundColor(1347529272);
    this.psG.setVisibility(4);
    this.psB = ((LinearLayout)paramView.findViewById(2131299269));
    paramj = (RelativeLayout.LayoutParams)this.psB.getLayoutParams();
    paramj.width = (psI - psJ);
    paramj.height = -2;
    this.psB.setLayoutParams(paramj);
    this.psu = ((WXRTEditText)paramView.findViewById(2131297578));
    this.pst = ((WXRTEditText)paramView.findViewById(2131297580));
    ((LinearLayout)paramView.findViewById(2131297579)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181649);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        d.this.psu.ceA();
        d.this.psu.requestFocus();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(181649);
      }
    });
    ((LinearLayout)paramView.findViewById(2131297581)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181650);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        d.this.pst.ceA();
        d.this.pst.requestFocus();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(181650);
      }
    });
    this.psu.setEditTextType(2);
    this.pst.setEditTextType(1);
    this.pst.pvl = this;
    this.psu.pvl = this;
    if (!this.prJ.pvV)
    {
      this.psu.setKeyListener(null);
      this.psu.setEnabled(false);
      this.psu.setFocusable(false);
      this.pst.setKeyListener(null);
      this.pst.setEnabled(false);
      this.pst.setFocusable(false);
    }
    this.prJ.q(this.pst);
    this.prJ.q(this.psu);
  }
  
  public void a(com.tencent.mm.plugin.editor.model.a.a parama, int paramInt1, int paramInt2)
  {
    ad.i("MicroMsg.EditorOtherItemHolder", "ImageItemHolder position is " + lM());
    this.pst.setPosInDataList(paramInt1);
    this.psu.setPosInDataList(paramInt1);
    if (e.isEnabled()) {
      e.ceP().a(this.psE, this.psF, this.psG, paramInt1);
    }
    parama.ptI = this.pst;
    parama.ptJ = this.psu;
    parama.ptK = null;
    if (parama.ptF) {
      if (parama.ptL) {
        this.pst.requestFocus();
      }
    }
    for (;;)
    {
      if (this.psv.getVisibility() == 0)
      {
        if (!parama.ptM) {
          break;
        }
        this.psv.setBackgroundResource(2131231974);
      }
      return;
      this.psu.requestFocus();
      continue;
      if (this.pst.hasFocus()) {
        this.pst.clearFocus();
      }
      if (this.psu.hasFocus()) {
        this.psu.clearFocus();
      }
    }
    this.psv.setBackgroundResource(2131231973);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.d
 * JD-Core Version:    0.7.0.1
 */