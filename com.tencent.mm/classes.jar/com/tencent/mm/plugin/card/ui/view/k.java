package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a;
import com.tencent.mm.av.a.a.c;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.agy;
import com.tencent.mm.protocal.protobuf.uz;
import java.util.LinkedList;

public final class k
  extends i
{
  private View qjY;
  
  public final void cxw()
  {
    AppMethodBeat.i(113680);
    if (this.qjY != null) {
      this.qjY.setVisibility(8);
    }
    AppMethodBeat.o(113680);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113679);
    if (this.qjY == null) {
      this.qjY = ((ViewStub)findViewById(2131298099)).inflate();
    }
    this.qjY.setOnClickListener(this.qjX.cvu());
    Object localObject1 = this.qjX.cvq().csQ().LeS;
    if (!TextUtils.isEmpty(((agy)localObject1).detail))
    {
      ((TextView)findViewById(2131298093)).setText(((agy)localObject1).detail);
      findViewById(2131298094).setVisibility(0);
    }
    ImageView localImageView;
    for (;;)
    {
      localImageView = (ImageView)findViewById(2131298098);
      if ((((agy)localObject1).LqB == null) || (((agy)localObject1).LqB.size() <= 0) || (TextUtils.isEmpty((CharSequence)((agy)localObject1).LqB.get(0)))) {
        break;
      }
      localObject1 = (String)((agy)localObject1).LqB.get(0);
      localImageView.setVisibility(0);
      Object localObject2 = new c.a();
      ((c.a)localObject2).prefixPath = com.tencent.mm.loader.j.b.aKJ();
      q.bcW();
      ((c.a)localObject2).jbw = null;
      ((c.a)localObject2).fullPath = m.ajp((String)localObject1);
      ((c.a)localObject2).jbf = true;
      ((c.a)localObject2).iaT = false;
      ((c.a)localObject2).jbd = true;
      localObject2 = ((c.a)localObject2).bdv();
      q.bcV().a((String)localObject1, localImageView, (c)localObject2);
      AppMethodBeat.o(113679);
      return;
      findViewById(2131298094).setVisibility(8);
    }
    localImageView.setVisibility(8);
    AppMethodBeat.o(113679);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.k
 * JD-Core Version:    0.7.0.1
 */