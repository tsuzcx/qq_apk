package com.tencent.mm.plugin.collect.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.collect.model.e;
import com.tencent.mm.ui.y;
import com.tencent.mm.wallet_core.ui.WalletTextView;

public class CollectBillHeaderView
  extends LinearLayout
{
  private TextView kFd;
  private TextView nNi;
  private WalletTextView nWM;
  private TextView nWN;
  
  public CollectBillHeaderView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(64034);
    init(paramContext);
    AppMethodBeat.o(64034);
  }
  
  public CollectBillHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(64035);
    init(paramContext);
    AppMethodBeat.o(64035);
  }
  
  public CollectBillHeaderView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(64036);
    init(paramContext);
    AppMethodBeat.o(64036);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(64037);
    paramContext = y.js(paramContext).inflate(2131493552, this);
    this.nNi = ((TextView)paramContext.findViewById(2131298432));
    this.nWN = ((TextView)paramContext.findViewById(2131298431));
    this.nWM = ((WalletTextView)paramContext.findViewById(2131298434));
    this.kFd = ((TextView)paramContext.findViewById(2131298433));
    AppMethodBeat.o(64037);
  }
  
  public final void b(int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    AppMethodBeat.i(64038);
    this.nNi.setText(e.a(getContext(), paramLong, paramInt3));
    this.nWM.setText(e.zG(paramInt2));
    this.kFd.setText(getContext().getString(2131757448, new Object[] { Integer.valueOf(paramInt1) }));
    AppMethodBeat.o(64038);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectBillHeaderView
 * JD-Core Version:    0.7.0.1
 */