package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelimage.loader.a;
import com.tencent.mm.modelimage.loader.a.c;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.card.a.c;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.akb;
import com.tencent.mm.protocal.protobuf.ws;
import java.util.LinkedList;

public final class k
  extends i
{
  private View wJt;
  
  public final void doE()
  {
    AppMethodBeat.i(113680);
    if (this.wJt != null) {
      this.wJt.setVisibility(8);
    }
    AppMethodBeat.o(113680);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113679);
    if (this.wJt == null) {
      this.wJt = ((ViewStub)findViewById(a.d.wge)).inflate();
    }
    if (this.wJs.dmk().djr()) {
      this.wJt.setBackgroundResource(a.c.wer);
    }
    this.wJt.setOnClickListener(this.wJs.dmo());
    Object localObject1 = this.wJs.dmk().djK().Zeb;
    if (!TextUtils.isEmpty(((akb)localObject1).detail))
    {
      ((TextView)findViewById(a.d.wfY)).setText(((akb)localObject1).detail);
      findViewById(a.d.wfZ).setVisibility(0);
    }
    ImageView localImageView;
    for (;;)
    {
      localImageView = (ImageView)findViewById(a.d.wgd);
      if ((((akb)localObject1).Zrh == null) || (((akb)localObject1).Zrh.size() <= 0) || (TextUtils.isEmpty((CharSequence)((akb)localObject1).Zrh.get(0)))) {
        break;
      }
      localObject1 = (String)((akb)localObject1).Zrh.get(0);
      localImageView.setVisibility(0);
      Object localObject2 = new c.a();
      ((c.a)localObject2).prefixPath = com.tencent.mm.loader.i.b.bmz();
      ((c.a)localObject2).oKH = r.bKf();
      ((c.a)localObject2).fullPath = m.akH((String)localObject1);
      ((c.a)localObject2).oKp = true;
      ((c.a)localObject2).nrc = false;
      ((c.a)localObject2).oKn = true;
      localObject2 = ((c.a)localObject2).bKx();
      r.bKe().a((String)localObject1, localImageView, (c)localObject2);
      AppMethodBeat.o(113679);
      return;
      findViewById(a.d.wfZ).setVisibility(8);
    }
    localImageView.setVisibility(8);
    AppMethodBeat.o(113679);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.k
 * JD-Core Version:    0.7.0.1
 */