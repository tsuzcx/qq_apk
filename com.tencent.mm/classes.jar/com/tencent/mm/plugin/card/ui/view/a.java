package com.tencent.mm.plugin.card.ui.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.ui.e.a;
import com.tencent.mm.plugin.card.ui.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.ccf;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;

public final class a
  extends i
{
  private View kAO;
  
  public final void bfq()
  {
    AppMethodBeat.i(88730);
    this.kAO.setVisibility(8);
    AppMethodBeat.o(88730);
  }
  
  public final void initView()
  {
    AppMethodBeat.i(88728);
    this.kAO = findViewById(2131822073);
    AppMethodBeat.o(88728);
  }
  
  public final void update()
  {
    AppMethodBeat.i(88729);
    Object localObject = this.kBh.bdA();
    b localb = this.kBh.bdv();
    MMActivity localMMActivity = this.kBh.bdy();
    e.a locala = this.kBh.bdC();
    f localf = this.kBh.bdD();
    if (((com.tencent.mm.plugin.card.ui.a.g)localObject).beO())
    {
      this.kAO.setVisibility(0);
      findViewById(2131821988).setVisibility(0);
      localObject = (ImageView)findViewById(2131821989);
      TextView localTextView1 = (TextView)findViewById(2131821990);
      TextView localTextView2 = (TextView)findViewById(2131821991);
      if (locala.ktc != null) {
        localTextView1.setText(com.tencent.mm.pluginsdk.ui.d.j.b(localMMActivity, ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(locala.ktc).Oe(), localTextView1.getTextSize()));
      }
      if (locala.ejF == 23) {
        if (!TextUtils.isEmpty(localb.bbd().wGz)) {
          localTextView2.setText(localb.bbd().wGz);
        }
      }
      for (;;)
      {
        a.b.a((ImageView)localObject, locala.ktc, 0.15F, false);
        ((ImageView)localObject).setOnClickListener(this.kBh.bdz());
        AppMethodBeat.o(88729);
        return;
        if (!TextUtils.isEmpty(localb.bbd().knv))
        {
          localTextView2.setText(localMMActivity.getString(2131298012, new Object[] { localb.bbd().knv }));
        }
        else
        {
          localTextView2.setText(localMMActivity.getString(2131298012, new Object[] { localf.getTitle() }));
          continue;
          if ((localb.bbf() != null) && (!TextUtils.isEmpty(localb.bbf().xMB))) {
            localTextView2.setText(localb.bbf().xMB);
          } else if (!TextUtils.isEmpty(localb.bbd().knv))
          {
            if (localb.baP()) {
              localTextView2.setText(localMMActivity.getString(2131297965, new Object[] { localb.bbd().knv }));
            } else {
              localTextView2.setText(localMMActivity.getString(2131297938, new Object[] { localb.bbd().knv }));
            }
          }
          else if (localb.baP()) {
            localTextView2.setText(localMMActivity.getString(2131297965, new Object[] { localf.getTitle() }));
          } else {
            localTextView2.setText(localMMActivity.getString(2131297938, new Object[] { localf.getTitle() }));
          }
        }
      }
    }
    if (((com.tencent.mm.plugin.card.ui.a.g)localObject).beP())
    {
      if (!TextUtils.isEmpty(localb.bbd().wGz))
      {
        this.kAO.setVisibility(0);
        findViewById(2131821988).setVisibility(8);
        ((TextView)findViewById(2131821991)).setText(localb.bbd().wGz);
        AppMethodBeat.o(88729);
        return;
      }
      this.kAO.setVisibility(8);
      AppMethodBeat.o(88729);
      return;
    }
    bfq();
    AppMethodBeat.o(88729);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.a
 * JD-Core Version:    0.7.0.1
 */