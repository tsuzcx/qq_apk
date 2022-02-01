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
import com.tencent.mm.protocal.protobuf.aeu;
import com.tencent.mm.protocal.protobuf.tu;
import java.util.LinkedList;

public final class k
  extends i
{
  private View oVe;
  
  public final void bZG()
  {
    AppMethodBeat.i(113680);
    if (this.oVe != null) {
      this.oVe.setVisibility(8);
    }
    AppMethodBeat.o(113680);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113679);
    if (this.oVe == null) {
      this.oVe = ((ViewStub)findViewById(2131297784)).inflate();
    }
    this.oVe.setOnClickListener(this.oVd.bXE());
    Object localObject1 = this.oVd.bXA().bVc().Gkp;
    if (!TextUtils.isEmpty(((aeu)localObject1).detail))
    {
      ((TextView)findViewById(2131297778)).setText(((aeu)localObject1).detail);
      findViewById(2131297779).setVisibility(0);
    }
    ImageView localImageView;
    for (;;)
    {
      localImageView = (ImageView)findViewById(2131297783);
      if ((((aeu)localObject1).GuW == null) || (((aeu)localObject1).GuW.size() <= 0) || (TextUtils.isEmpty((CharSequence)((aeu)localObject1).GuW.get(0)))) {
        break;
      }
      localObject1 = (String)((aeu)localObject1).GuW.get(0);
      localImageView.setVisibility(0);
      Object localObject2 = new c.a();
      ((c.a)localObject2).prefixPath = com.tencent.mm.loader.j.b.asj();
      q.aJc();
      ((c.a)localObject2).igB = null;
      ((c.a)localObject2).hgD = m.Zk((String)localObject1);
      ((c.a)localObject2).igk = true;
      ((c.a)localObject2).hhW = false;
      ((c.a)localObject2).igi = true;
      localObject2 = ((c.a)localObject2).aJu();
      q.aJb().a((String)localObject1, localImageView, (c)localObject2);
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