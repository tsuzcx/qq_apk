package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;

public class AAQueryListH5UrlFooterView
  extends LinearLayout
{
  private TextView pIM;
  
  public AAQueryListH5UrlFooterView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(63499);
    init(paramContext);
    AppMethodBeat.o(63499);
  }
  
  public AAQueryListH5UrlFooterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(63500);
    init(paramContext);
    AppMethodBeat.o(63500);
  }
  
  public AAQueryListH5UrlFooterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(63501);
    init(paramContext);
    AppMethodBeat.o(63501);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(63502);
    this.pIM = ((TextView)af.mU(paramContext).inflate(a.g.aa_record_list_h5url_footer, this, true).findViewById(a.f.aa_record_bottom_link_tv));
    aw.a(this.pIM.getPaint(), 0.8F);
    AppMethodBeat.o(63502);
  }
  
  public TextView getBottomLinkTv()
  {
    return this.pIM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAQueryListH5UrlFooterView
 * JD-Core Version:    0.7.0.1
 */