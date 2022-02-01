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
import com.tencent.mm.aw.o;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.abm;
import com.tencent.mm.protocal.protobuf.ro;
import java.util.LinkedList;

public final class k
  extends i
{
  private View nIh;
  
  public final void bMB()
  {
    AppMethodBeat.i(113680);
    if (this.nIh != null) {
      this.nIh.setVisibility(8);
    }
    AppMethodBeat.o(113680);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113679);
    if (this.nIh == null) {
      this.nIh = ((ViewStub)findViewById(2131297784)).inflate();
    }
    this.nIh.setOnClickListener(this.nIg.bKx());
    Object localObject1 = this.nIg.bKt().bHV().CRW;
    if (!TextUtils.isEmpty(((abm)localObject1).detail))
    {
      ((TextView)findViewById(2131297778)).setText(((abm)localObject1).detail);
      findViewById(2131297779).setVisibility(0);
    }
    ImageView localImageView;
    for (;;)
    {
      localImageView = (ImageView)findViewById(2131297783);
      if ((((abm)localObject1).DbO == null) || (((abm)localObject1).DbO.size() <= 0) || (TextUtils.isEmpty((CharSequence)((abm)localObject1).DbO.get(0)))) {
        break;
      }
      localObject1 = (String)((abm)localObject1).DbO.get(0);
      localImageView.setVisibility(0);
      Object localObject2 = new c.a();
      ((c.a)localObject2).prefixPath = com.tencent.mm.loader.j.b.aih();
      o.ayK();
      ((c.a)localObject2).hkl = null;
      ((c.a)localObject2).gjt = m.Qy((String)localObject1);
      ((c.a)localObject2).hjU = true;
      ((c.a)localObject2).gkG = false;
      ((c.a)localObject2).hjS = true;
      localObject2 = ((c.a)localObject2).azc();
      o.ayJ().a((String)localObject1, localImageView, (c)localObject2);
      AppMethodBeat.o(113679);
      return;
      findViewById(2131297779).setVisibility(8);
    }
    localImageView.setVisibility(8);
    AppMethodBeat.o(113679);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.k
 * JD-Core Version:    0.7.0.1
 */