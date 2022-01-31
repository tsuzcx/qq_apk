package com.tencent.mm.plugin.account.friend.ui;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.p;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.d.a;
import com.tencent.mm.ah.o;
import com.tencent.mm.kernel.e;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.pluginsdk.ui.tools.c;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;

public class InviteFriendUI
  extends MMActivity
  implements d.a
{
  private ImageView gxs;
  private String gzq;
  private int gzr;
  private String gzs;
  private String gzt;
  private String gzu;
  private Button gzv;
  private int gzw;
  private int gzx;
  private String gzy = null;
  private String gzz = null;
  
  public int getLayoutId()
  {
    return 2130969908;
  }
  
  public void initView()
  {
    AppMethodBeat.i(108584);
    this.gxs = ((ImageView)findViewById(2131823967));
    TextView localTextView1 = (TextView)findViewById(2131823968);
    TextView localTextView3 = (TextView)findViewById(2131825150);
    TextView localTextView2 = (TextView)findViewById(2131823969);
    this.gzv = ((Button)findViewById(2131823970));
    Button localButton = (Button)findViewById(2131825152);
    localTextView1.setText(this.gzs);
    localTextView2.setText(getString(2131300754, new Object[] { this.gzs }));
    Object localObject;
    if (this.gzr == 1)
    {
      this.gxs.setBackgroundDrawable(com.tencent.mm.cb.a.k(this, 2131231221));
      localTextView3.setText(getString(2131296939) + this.gzq);
      localObject = com.tencent.mm.a.g.w(this.gzq.getBytes());
      if (!com.tencent.mm.kernel.g.RL().isSDCardAvailable())
      {
        localObject = o.acQ().bZ(ah.getContext());
        if (localObject == null) {
          break label578;
        }
        this.gxs.setImageBitmap((Bitmap)localObject);
      }
    }
    else
    {
      label200:
      if (this.gzr == 0)
      {
        this.gxs.setBackgroundDrawable(com.tencent.mm.cb.a.k(this, 2131231226));
        localTextView3.setText(getString(2131296944) + this.gzq);
        long l = p.cU(this.gzq);
        localObject = null;
        if (l != 0L) {
          localObject = com.tencent.mm.ah.b.gB(l);
        }
        if (localObject != null) {
          break label594;
        }
        this.gxs.setImageDrawable(com.tencent.mm.cb.a.k(this, 2131231226));
        localButton.setVisibility(0);
      }
      label290:
      if (this.gzr == 2)
      {
        this.gzv.setText(2131300493);
        this.gxs.setBackgroundDrawable(com.tencent.mm.cb.a.k(this, 2130838495));
        localTextView3.setText(getString(2131296931) + this.gzq);
        if (com.tencent.mm.kernel.g.RL().isSDCardAvailable()) {
          break label605;
        }
        localObject = o.acQ().bZ(ah.getContext());
        label376:
        if (localObject == null) {
          break label616;
        }
        this.gxs.setImageBitmap((Bitmap)localObject);
        if (TextUtils.isEmpty(this.gzs))
        {
          localTextView1.setText(bo.aqf(this.gzq));
          localTextView2.setText(getString(2131300754, new Object[] { bo.aqf(this.gzq) }));
        }
      }
      label388:
      if (this.gzr == 3)
      {
        this.gzv.setText(2131300753);
        localObject = x.a(new c(this.gzz, this.gzz));
        if (localObject == null) {
          break label632;
        }
        this.gxs.setImageBitmap((Bitmap)localObject);
      }
    }
    for (;;)
    {
      localButton.setVisibility(8);
      this.gzv.setOnClickListener(new InviteFriendUI.1(this));
      localButton.setOnClickListener(new InviteFriendUI.2(this));
      setBackBtn(new InviteFriendUI.3(this));
      AppMethodBeat.o(108584);
      return;
      localObject = ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).xa((String)localObject);
      if (localObject != null)
      {
        localObject = l.b(((com.tencent.mm.plugin.account.friend.a.a)localObject).apY(), this);
        break;
      }
      localObject = null;
      break;
      label578:
      this.gxs.setImageDrawable(com.tencent.mm.cb.a.k(this, 2131231221));
      break label200;
      label594:
      this.gxs.setImageBitmap((Bitmap)localObject);
      break label290;
      label605:
      localObject = com.tencent.mm.ah.b.qK(this.gzt);
      break label376;
      label616:
      this.gxs.setImageDrawable(com.tencent.mm.cb.a.k(this, 2130838495));
      break label388;
      label632:
      this.gxs.setImageResource(2131231207);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(108580);
    super.onCreate(paramBundle);
    setMMTitle(2131300756);
    paramBundle = getIntent();
    this.gzr = paramBundle.getIntExtra("friend_type", -1);
    this.gzs = paramBundle.getStringExtra("friend_nick");
    this.gzq = paramBundle.getStringExtra("friend_num");
    this.gzt = paramBundle.getStringExtra("friend_googleID");
    this.gzu = paramBundle.getStringExtra("friend_googleItemID");
    this.gzq = bo.nullAsNil(this.gzq);
    this.gzy = paramBundle.getStringExtra("friend_linkedInID");
    this.gzz = paramBundle.getStringExtra("friend_linkedInPicUrl");
    initView();
    this.gzw = paramBundle.getIntExtra("search_kvstat_scene", 0);
    this.gzx = paramBundle.getIntExtra("search_kvstat_position", 0);
    AppMethodBeat.o(108580);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(108583);
    super.onDestroy();
    AppMethodBeat.o(108583);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(108581);
    super.onPause();
    o.acQ().e(this);
    AppMethodBeat.o(108581);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(108582);
    super.onResume();
    o.acQ().d(this);
    AppMethodBeat.o(108582);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void re(String paramString)
  {
    AppMethodBeat.i(108585);
    if ((this.gzq == null) || (this.gzq.equals("")))
    {
      AppMethodBeat.o(108585);
      return;
    }
    long l = com.tencent.mm.ah.b.qP(paramString);
    if ((l > 0L) && (this.gzq.equals(String.valueOf(l))) && (this.gzr == 0)) {
      this.gxs.setImageBitmap(com.tencent.mm.ah.b.b(paramString, false, -1));
    }
    AppMethodBeat.o(108585);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.InviteFriendUI
 * JD-Core Version:    0.7.0.1
 */