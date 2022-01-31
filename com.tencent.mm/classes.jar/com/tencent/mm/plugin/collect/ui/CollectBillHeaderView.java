package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.collect.model.e;
import com.tencent.mm.ui.w;
import com.tencent.mm.wallet_core.ui.WalletTextView;

public class CollectBillHeaderView
  extends LinearLayout
{
  private TextView kGe;
  private TextView kPB;
  private WalletTextView kQx;
  private TextView kQy;
  
  public CollectBillHeaderView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(41173);
    init(paramContext);
    AppMethodBeat.o(41173);
  }
  
  public CollectBillHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(41174);
    init(paramContext);
    AppMethodBeat.o(41174);
  }
  
  public CollectBillHeaderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(41175);
    init(paramContext);
    AppMethodBeat.o(41175);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(41176);
    paramContext = w.hM(paramContext).inflate(2130969170, this);
    this.kGe = ((TextView)paramContext.findViewById(2131822893));
    this.kQy = ((TextView)paramContext.findViewById(2131822894));
    this.kQx = ((WalletTextView)paramContext.findViewById(2131822895));
    this.kPB = ((TextView)paramContext.findViewById(2131822896));
    AppMethodBeat.o(41176);
  }
  
  public final void a(int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    AppMethodBeat.i(41177);
    this.kGe.setText(e.a(getContext(), paramLong, paramInt3));
    this.kQx.setText(e.tN(paramInt2));
    this.kPB.setText(getContext().getString(2131298436, new Object[] { Integer.valueOf(paramInt1) }));
    AppMethodBeat.o(41177);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillHeaderView
 * JD-Core Version:    0.7.0.1
 */