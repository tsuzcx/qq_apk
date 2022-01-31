package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.protocal.protobuf.ye;
import java.util.LinkedList;

public final class k
  extends i
{
  private View kBi;
  
  public final void bfq()
  {
    AppMethodBeat.i(88753);
    if (this.kBi != null) {
      this.kBi.setVisibility(8);
    }
    AppMethodBeat.o(88753);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(88752);
    if (this.kBi == null) {
      this.kBi = ((ViewStub)findViewById(2131822085)).inflate();
    }
    this.kBi.setOnClickListener(this.kBh.bdz());
    Object localObject1 = this.kBh.bdv().bbd().wGr;
    if (!TextUtils.isEmpty(((ye)localObject1).detail))
    {
      ((TextView)findViewById(2131822066)).setText(((ye)localObject1).detail);
      findViewById(2131822065).setVisibility(0);
    }
    ImageView localImageView;
    for (;;)
    {
      localImageView = (ImageView)findViewById(2131822064);
      if ((((ye)localObject1).wPk == null) || (((ye)localObject1).wPk.size() <= 0) || (TextUtils.isEmpty((CharSequence)((ye)localObject1).wPk.get(0)))) {
        break;
      }
      localObject1 = (String)((ye)localObject1).wPk.get(0);
      localImageView.setVisibility(0);
      Object localObject2 = new c.a();
      ((c.a)localObject2).eNP = e.eQz;
      o.ahH();
      ((c.a)localObject2).eOd = null;
      ((c.a)localObject2).eNO = m.HO((String)localObject1);
      ((c.a)localObject2).eNM = true;
      ((c.a)localObject2).eOk = false;
      ((c.a)localObject2).eNK = true;
      localObject2 = ((c.a)localObject2).ahY();
      o.ahG().a((String)localObject1, localImageView, (c)localObject2);
      AppMethodBeat.o(88752);
      return;
      findViewById(2131822065).setVisibility(8);
    }
    localImageView.setVisibility(8);
    AppMethodBeat.o(88752);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.k
 * JD-Core Version:    0.7.0.1
 */