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
import com.tencent.mm.av.o;
import com.tencent.mm.plugin.card.model.m;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.protocal.protobuf.acl;
import com.tencent.mm.protocal.protobuf.ry;
import java.util.LinkedList;

public final class k
  extends i
{
  private View olh;
  
  public final void bTM()
  {
    AppMethodBeat.i(113680);
    if (this.olh != null) {
      this.olh.setVisibility(8);
    }
    AppMethodBeat.o(113680);
  }
  
  public final void initView() {}
  
  public final void update()
  {
    AppMethodBeat.i(113679);
    if (this.olh == null) {
      this.olh = ((ViewStub)findViewById(2131297784)).inflate();
    }
    this.olh.setOnClickListener(this.olg.bRK());
    Object localObject1 = this.olg.bRG().bPi().EkH;
    if (!TextUtils.isEmpty(((acl)localObject1).detail))
    {
      ((TextView)findViewById(2131297778)).setText(((acl)localObject1).detail);
      findViewById(2131297779).setVisibility(0);
    }
    ImageView localImageView;
    for (;;)
    {
      localImageView = (ImageView)findViewById(2131297783);
      if ((((acl)localObject1).EuV == null) || (((acl)localObject1).EuV.size() <= 0) || (TextUtils.isEmpty((CharSequence)((acl)localObject1).EuV.get(0)))) {
        break;
      }
      localObject1 = (String)((acl)localObject1).EuV.get(0);
      localImageView.setVisibility(0);
      Object localObject2 = new c.a();
      ((c.a)localObject2).prefixPath = com.tencent.mm.loader.j.b.aph();
      o.aFC();
      ((c.a)localObject2).hKO = null;
      ((c.a)localObject2).gKe = m.UK((String)localObject1);
      ((c.a)localObject2).hKx = true;
      ((c.a)localObject2).gLt = false;
      ((c.a)localObject2).hKv = true;
      localObject2 = ((c.a)localObject2).aFT();
      o.aFB().a((String)localObject1, localImageView, (c)localObject2);
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