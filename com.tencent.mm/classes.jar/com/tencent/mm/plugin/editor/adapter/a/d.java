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
import com.tencent.mm.sdk.platformtools.ae;

public abstract class d
  extends a
{
  public static float pzn = Resources.getSystem().getDisplayMetrics().density;
  public static int pzo = Resources.getSystem().getDisplayMetrics().widthPixels;
  public static int pzp = (int)(40.0F * pzn + 0.5F);
  public ImageView dtJ;
  public LinearLayout jnX;
  public WXRTEditText pyZ;
  public WXRTEditText pza;
  public LinearLayout pzb;
  public TextView pzc;
  public TextView pzd;
  public ImageView pze;
  public View pzf;
  public LinearLayout pzg;
  public LinearLayout pzh;
  public LinearLayout pzi;
  public LinearLayout pzj;
  public LinearLayout pzk;
  public LinearLayout pzl;
  public LinearLayout pzm;
  public View.OnClickListener pzq = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      AppMethodBeat.i(181651);
      b localb = new b();
      localb.bd(paramAnonymousView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      d.this.pyp.pCt.ceU().ceK();
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(181651);
    }
  };
  
  public d(View paramView, j paramj)
  {
    super(paramView, paramj);
    this.dtJ = ((ImageView)paramView.findViewById(2131299257));
    this.pzf = paramView.findViewById(2131306315);
    this.pzb = ((LinearLayout)paramView.findViewById(2131302917));
    this.jnX = ((LinearLayout)paramView.findViewById(2131302943));
    this.pzc = ((TextView)paramView.findViewById(2131302918));
    this.pzd = ((TextView)paramView.findViewById(2131302915));
    this.pze = ((ImageView)paramView.findViewById(2131302916));
    this.pzc.setTextSize(16.0F);
    this.pzd.setTextSize(12.0F);
    this.pzg = ((LinearLayout)paramView.findViewById(2131302941));
    this.pzg.setVisibility(8);
    this.pzi = ((LinearLayout)paramView.findViewById(2131302936));
    this.pzi.setVisibility(8);
    this.pzj = ((LinearLayout)paramView.findViewById(2131302914));
    this.pzj.setVisibility(8);
    this.pzk = ((LinearLayout)paramView.findViewById(2131303103));
    this.pzk.setBackgroundColor(1347529272);
    this.pzk.setVisibility(8);
    this.pzk.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181648);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        e.cge().cgj();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(181648);
      }
    });
    this.pzl = ((LinearLayout)paramView.findViewById(2131303110));
    this.pzl.setBackgroundColor(1347529272);
    this.pzl.setVisibility(4);
    this.pzm = ((LinearLayout)paramView.findViewById(2131303105));
    this.pzm.setBackgroundColor(1347529272);
    this.pzm.setVisibility(4);
    this.pzh = ((LinearLayout)paramView.findViewById(2131299269));
    paramj = (RelativeLayout.LayoutParams)this.pzh.getLayoutParams();
    paramj.width = (pzo - pzp);
    paramj.height = -2;
    this.pzh.setLayoutParams(paramj);
    this.pza = ((WXRTEditText)paramView.findViewById(2131297578));
    this.pyZ = ((WXRTEditText)paramView.findViewById(2131297580));
    ((LinearLayout)paramView.findViewById(2131297579)).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181649);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        d.this.pza.cfP();
        d.this.pza.requestFocus();
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
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        d.this.pyZ.cfP();
        d.this.pyZ.requestFocus();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/editor/adapter/itemholder/EditorOtherItemHolder$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(181650);
      }
    });
    this.pza.setEditTextType(2);
    this.pyZ.setEditTextType(1);
    this.pyZ.pBP = this;
    this.pza.pBP = this;
    if (!this.pyp.pCz)
    {
      this.pza.setKeyListener(null);
      this.pza.setEnabled(false);
      this.pza.setFocusable(false);
      this.pyZ.setKeyListener(null);
      this.pyZ.setEnabled(false);
      this.pyZ.setFocusable(false);
    }
    this.pyp.q(this.pyZ);
    this.pyp.q(this.pza);
  }
  
  public void a(com.tencent.mm.plugin.editor.model.a.a parama, int paramInt1, int paramInt2)
  {
    ae.i("MicroMsg.EditorOtherItemHolder", "ImageItemHolder position is " + lM());
    this.pyZ.setPosInDataList(paramInt1);
    this.pza.setPosInDataList(paramInt1);
    if (e.isEnabled()) {
      e.cge().a(this.pzk, this.pzl, this.pzm, paramInt1);
    }
    parama.pAm = this.pyZ;
    parama.pAn = this.pza;
    parama.pAo = null;
    if (parama.pAj) {
      if (parama.pAp) {
        this.pyZ.requestFocus();
      }
    }
    for (;;)
    {
      if (this.pzb.getVisibility() == 0)
      {
        if (!parama.pAq) {
          break;
        }
        this.pzb.setBackgroundResource(2131231974);
      }
      return;
      this.pza.requestFocus();
      continue;
      if (this.pyZ.hasFocus()) {
        this.pyZ.clearFocus();
      }
      if (this.pza.hasFocus()) {
        this.pza.clearFocus();
      }
    }
    this.pzb.setBackgroundResource(2131231973);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.adapter.a.d
 * JD-Core Version:    0.7.0.1
 */