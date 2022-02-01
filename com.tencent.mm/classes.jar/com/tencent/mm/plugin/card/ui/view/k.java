package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a;
import com.tencent.mm.aw.a.a.c;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.q;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.ael;
import com.tencent.mm.protocal.protobuf.ts;
import java.util.LinkedList;

public final class k
  extends i
{
  private View oOC;
  
  public final void bYr()
  {
    AppMethodBeat.i(113680);
    if (this.oOC != null) {
      this.oOC.setVisibility(8);
    }
    AppMethodBeat.o(113680);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113679);
    if (this.oOC == null) {
      this.oOC = ((ViewStub)findViewById(2131297784)).inflate();
    }
    this.oOC.setOnClickListener(this.oOB.bWp());
    Object localObject1 = this.oOB.bWl().bTN().FRQ;
    if (!TextUtils.isEmpty(((ael)localObject1).detail))
    {
      ((TextView)findViewById(2131297778)).setText(((ael)localObject1).detail);
      findViewById(2131297779).setVisibility(0);
    }
    ImageView localImageView;
    for (;;)
    {
      localImageView = (ImageView)findViewById(2131297783);
      if ((((ael)localObject1).Gcp == null) || (((ael)localObject1).Gcp.size() <= 0) || (TextUtils.isEmpty((CharSequence)((ael)localObject1).Gcp.get(0)))) {
        break;
      }
      localObject1 = (String)((ael)localObject1).Gcp.get(0);
      localImageView.setVisibility(0);
      Object localObject2 = new c.a();
      ((c.a)localObject2).prefixPath = com.tencent.mm.loader.j.b.arU();
      q.aIK();
      ((c.a)localObject2).idJ = null;
      ((c.a)localObject2).hdP = m.Yt((String)localObject1);
      ((c.a)localObject2).idr = true;
      ((c.a)localObject2).hfi = false;
      ((c.a)localObject2).idp = true;
      localObject2 = ((c.a)localObject2).aJc();
      q.aIJ().a((String)localObject1, localImageView, (c)localObject2);
      AppMethodBeat.o(113679);
      return;
      findViewById(2131297779).setVisibility(8);
    }
    localImageView.setVisibility(8);
    AppMethodBeat.o(113679);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.k
 * JD-Core Version:    0.7.0.1
 */