package com.tencent.mm.plugin.account.friend.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ag.d.a;
import com.tencent.mm.kernel.e;
import com.tencent.mm.platformtools.x;
import com.tencent.mm.plugin.account.friend.a.c;
import com.tencent.mm.plugin.account.friend.a.d;
import com.tencent.mm.plugin.account.friend.a.e;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.plugin.account.friend.a.h;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;

public class InviteFriendUI
  extends MMActivity
  implements d.a
{
  private ImageView ffK;
  private String fhJ;
  private int fhK;
  private String fhL;
  private String fhM;
  private String fhN;
  private Button fhO;
  private int fhP;
  private int fhQ;
  private String fhR = null;
  private String fhS = null;
  
  protected final int getLayoutId()
  {
    return a.e.invite_friend;
  }
  
  protected final void initView()
  {
    this.ffK = ((ImageView)findViewById(a.d.invite_friend_avatar_iv));
    TextView localTextView1 = (TextView)findViewById(a.d.invite_friend_nickname_tv);
    TextView localTextView3 = (TextView)findViewById(a.d.invite_friend_num_tv);
    TextView localTextView2 = (TextView)findViewById(a.d.invite_friend_not_reg);
    this.fhO = ((Button)findViewById(a.d.invite_friend_invite_btn));
    Button localButton = (Button)findViewById(a.d.invite_friend_send_qq_message);
    localTextView1.setText(this.fhL);
    localTextView2.setText(getString(a.h.invite_friend_not_reg, new Object[] { this.fhL }));
    label204:
    long l;
    if (this.fhK == 1)
    {
      this.ffK.setBackgroundDrawable(com.tencent.mm.cb.a.g(this, a.g.default_mobile_avatar));
      localTextView3.setText(getString(a.h.app_field_mobile) + this.fhJ);
      localObject = com.tencent.mm.a.g.o(this.fhJ.getBytes());
      if (!com.tencent.mm.kernel.g.DP().isSDCardAvailable())
      {
        localObject = com.tencent.mm.ag.o.JQ().bv(ae.getContext());
        if (localObject == null) {
          break label584;
        }
        this.ffK.setImageBitmap((Bitmap)localObject);
      }
    }
    else if (this.fhK == 0)
    {
      this.ffK.setBackgroundDrawable(com.tencent.mm.cb.a.g(this, a.g.default_qq_avatar));
      localTextView3.setText(getString(a.h.app_field_qquin) + this.fhJ);
      l = com.tencent.mm.a.o.bS(this.fhJ);
      if (l == 0L) {
        break label653;
      }
    }
    label384:
    label396:
    label653:
    for (Object localObject = com.tencent.mm.ag.b.bG(l);; localObject = null)
    {
      if (localObject == null)
      {
        this.ffK.setImageDrawable(com.tencent.mm.cb.a.g(this, a.g.default_qq_avatar));
        label295:
        localButton.setVisibility(0);
        if (this.fhK == 2)
        {
          this.fhO.setText(a.h.gcontact_send_invite);
          this.ffK.setBackgroundDrawable(com.tencent.mm.cb.a.g(this, a.c.default_google_avatar));
          localTextView3.setText(getString(a.h.app_field_email) + this.fhJ);
          if (com.tencent.mm.kernel.g.DP().isSDCardAvailable()) {
            break label612;
          }
          localObject = com.tencent.mm.ag.o.JQ().bv(ae.getContext());
          if (localObject == null) {
            break label623;
          }
          this.ffK.setImageBitmap((Bitmap)localObject);
          if (TextUtils.isEmpty(this.fhL))
          {
            localTextView1.setText(bk.aab(this.fhJ));
            localTextView2.setText(getString(a.h.invite_friend_not_reg, new Object[] { bk.aab(this.fhJ) }));
          }
        }
        if (this.fhK == 3)
        {
          this.fhO.setText(a.h.invite_friend_linkedin_invite);
          localObject = x.a(new com.tencent.mm.pluginsdk.ui.tools.d(this.fhS, this.fhS));
          if (localObject == null) {
            break label640;
          }
          this.ffK.setImageBitmap((Bitmap)localObject);
        }
      }
      for (;;)
      {
        localButton.setVisibility(8);
        this.fhO.setOnClickListener(new InviteFriendUI.1(this));
        localButton.setOnClickListener(new InviteFriendUI.2(this));
        setBackBtn(new InviteFriendUI.3(this));
        return;
        localObject = ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).pI((String)localObject);
        if (localObject != null)
        {
          localObject = l.b(((com.tencent.mm.plugin.account.friend.a.a)localObject).Ww(), this);
          break;
        }
        localObject = null;
        break;
        label584:
        this.ffK.setImageDrawable(com.tencent.mm.cb.a.g(this, a.g.default_mobile_avatar));
        break label204;
        this.ffK.setImageBitmap((Bitmap)localObject);
        break label295;
        label612:
        localObject = com.tencent.mm.ag.b.jR(this.fhM);
        break label384;
        label623:
        this.ffK.setImageDrawable(com.tencent.mm.cb.a.g(this, a.c.default_google_avatar));
        break label396;
        this.ffK.setImageResource(a.g.default_avatar);
      }
    }
  }
  
  public final void kk(String paramString)
  {
    if ((this.fhJ == null) || (this.fhJ.equals(""))) {}
    long l;
    do
    {
      return;
      l = com.tencent.mm.ag.b.jW(paramString);
    } while ((l <= 0L) || (!this.fhJ.equals(String.valueOf(l))) || (this.fhK != 0));
    this.ffK.setImageBitmap(com.tencent.mm.ag.b.a(paramString, false, -1));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(a.h.invite_friend_title);
    paramBundle = getIntent();
    this.fhK = paramBundle.getIntExtra("friend_type", -1);
    this.fhL = paramBundle.getStringExtra("friend_nick");
    this.fhJ = paramBundle.getStringExtra("friend_num");
    this.fhM = paramBundle.getStringExtra("friend_googleID");
    this.fhN = paramBundle.getStringExtra("friend_googleItemID");
    this.fhJ = bk.pm(this.fhJ);
    this.fhR = paramBundle.getStringExtra("friend_linkedInID");
    this.fhS = paramBundle.getStringExtra("friend_linkedInPicUrl");
    initView();
    this.fhP = paramBundle.getIntExtra("search_kvstat_scene", 0);
    this.fhQ = paramBundle.getIntExtra("search_kvstat_position", 0);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  protected void onPause()
  {
    super.onPause();
    com.tencent.mm.ag.o.JQ().e(this);
  }
  
  protected void onResume()
  {
    super.onResume();
    com.tencent.mm.ag.o.JQ().d(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.InviteFriendUI
 * JD-Core Version:    0.7.0.1
 */