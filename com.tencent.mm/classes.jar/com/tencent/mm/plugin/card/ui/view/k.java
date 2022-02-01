package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.a.a;
import com.tencent.mm.ay.a.a.c;
import com.tencent.mm.ay.a.a.c.a;
import com.tencent.mm.ay.q;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.ahk;
import com.tencent.mm.protocal.protobuf.vb;
import java.util.LinkedList;

public final class k
  extends i
{
  private View tFU;
  
  public final void cKY()
  {
    AppMethodBeat.i(113680);
    if (this.tFU != null) {
      this.tFU.setVisibility(8);
    }
    AppMethodBeat.o(113680);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113679);
    if (this.tFU == null) {
      this.tFU = ((ViewStub)findViewById(a.d.tbR)).inflate();
    }
    this.tFU.setOnClickListener(this.tFT.cIW());
    Object localObject1 = this.tFT.cIS().cGs().Sgg;
    if (!TextUtils.isEmpty(((ahk)localObject1).detail))
    {
      ((TextView)findViewById(a.d.tbL)).setText(((ahk)localObject1).detail);
      findViewById(a.d.tbM).setVisibility(0);
    }
    ImageView localImageView;
    for (;;)
    {
      localImageView = (ImageView)findViewById(a.d.tbQ);
      if ((((ahk)localObject1).SrZ == null) || (((ahk)localObject1).SrZ.size() <= 0) || (TextUtils.isEmpty((CharSequence)((ahk)localObject1).SrZ.get(0)))) {
        break;
      }
      localObject1 = (String)((ahk)localObject1).SrZ.get(0);
      localImageView.setVisibility(0);
      Object localObject2 = new c.a();
      ((c.a)localObject2).prefixPath = com.tencent.mm.loader.j.b.aSL();
      q.bmm();
      ((c.a)localObject2).lRV = null;
      ((c.a)localObject2).fullPath = m.arc((String)localObject1);
      ((c.a)localObject2).lRD = true;
      ((c.a)localObject2).kPz = false;
      ((c.a)localObject2).lRB = true;
      localObject2 = ((c.a)localObject2).bmL();
      q.bml().a((String)localObject1, localImageView, (c)localObject2);
      AppMethodBeat.o(113679);
      return;
      findViewById(a.d.tbM).setVisibility(8);
    }
    localImageView.setVisibility(8);
    AppMethodBeat.o(113679);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.k
 * JD-Core Version:    0.7.0.1
 */