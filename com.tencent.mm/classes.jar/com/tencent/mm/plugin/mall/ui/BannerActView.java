package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.mall.a;
import com.tencent.mm.plugin.wallet_core.model.mall.b;
import com.tencent.mm.plugin.wallet_core.model.w;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;

public class BannerActView
  extends LinearLayout
{
  private List<a> oyd;
  private w oye;
  private TextView oyf;
  
  public BannerActView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(43128);
    this.oyf = ((TextView)LayoutInflater.from(getContext()).inflate(2130968836, this, true).findViewById(2131821740));
    setOnClickListener(new BannerActView.1(this));
    AppMethodBeat.o(43128);
  }
  
  public void setActivityList(List<a> paramList)
  {
    AppMethodBeat.i(43130);
    this.oyd = paramList;
    if ((this.oyd == null) || (this.oyd.size() <= 0)) {
      ab.i("MicroMsg.BannerActivityView", "func[setActivityList] actList null");
    }
    while (!b.dW(this.oyd))
    {
      setVisibility(8);
      AppMethodBeat.o(43130);
      return;
    }
    this.oyf.setText(((a)this.oyd.get(0)).umd);
    setVisibility(0);
    AppMethodBeat.o(43130);
  }
  
  public void setData(w paramw)
  {
    AppMethodBeat.i(43129);
    this.oye = paramw;
    if (this.oye != null)
    {
      this.oyf.setText(this.oye.field_bulletin_content);
      setVisibility(0);
      AppMethodBeat.o(43129);
      return;
    }
    setVisibility(8);
    AppMethodBeat.o(43129);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.BannerActView
 * JD-Core Version:    0.7.0.1
 */