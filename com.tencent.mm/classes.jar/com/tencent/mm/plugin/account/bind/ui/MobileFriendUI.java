package com.tencent.mm.plugin.account.bind.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.a.e;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.a.ab;
import com.tencent.mm.plugin.account.friend.a.al;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.ui.tools.n;
import java.util.List;

public class MobileFriendUI
  extends MMActivity
  implements com.tencent.mm.ah.f
{
  private ProgressDialog dnm = null;
  private TextView emptyTipTv = null;
  private ListView fem;
  b fen;
  private View feo;
  private al fep;
  String feq;
  private TextView fer = null;
  
  private void getData()
  {
    if (!l.WO())
    {
      localObject = this.mController.uMN;
      getString(a.i.app_tip);
      this.dnm = com.tencent.mm.ui.base.h.b((Context)localObject, getString(a.i.mobile_friend_loading), true, new MobileFriendUI.9(this));
      if (this.fen.getCount() != 0) {
        break label100;
      }
      if ((!((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBook(new MobileFriendUI.10(this))) && (this.dnm != null))
      {
        this.dnm.dismiss();
        this.dnm = null;
      }
    }
    return;
    label100:
    Object localObject = l.WW();
    List localList = l.WV();
    if ((((List)localObject).size() != 0) || (localList.size() != 0))
    {
      this.fep = new al(l.WW(), l.WV());
      com.tencent.mm.kernel.g.Dk().a(this.fep, 0);
      return;
    }
    localObject = new ab();
    com.tencent.mm.kernel.g.Dk().a((com.tencent.mm.ah.m)localObject, 0);
  }
  
  public final void b(com.tencent.mm.plugin.account.friend.a.a parama)
  {
    if (bk.bl(parama.getUsername()))
    {
      y.e("MicroMsg.MobileFriendUI", "username is null");
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", parama.getUsername());
    localIntent.putExtra("Contact_Nick", parama.WA());
    localIntent.putExtra("Contact_Mobile_MD5", parama.Wv());
    localIntent.putExtra("Contact_Alias", parama.ffm);
    localIntent.putExtra("Contact_Sex", parama.ffh);
    localIntent.putExtra("Contact_Signature", parama.ffk);
    localIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.ao(parama.ffq, parama.ffi, parama.ffj));
    localIntent.putExtra("Contact_Scene", 13);
    localIntent.putExtra("Contact_ShowUserName", false);
    com.tencent.mm.plugin.account.a.a.eUR.d(localIntent, this);
  }
  
  protected final int getLayoutId()
  {
    return a.f.mobile_friend;
  }
  
  protected final void initView()
  {
    this.emptyTipTv = ((TextView)findViewById(a.e.mobile_friend_empty_msg_tip_tv));
    this.emptyTipTv.setText(a.i.mobile_friend_empty_qmsg_tip);
    this.fer = ((TextView)findViewById(a.e.empty_mobile_friend_search_tip_tv));
    this.fer.setText(a.i.mobile_search_no_friend);
    this.feo = findViewById(a.e.mobile_friend_mobile_not_bind_ll);
    this.fem = ((ListView)findViewById(a.e.mobile_friend_lv));
    Object localObject = new n((byte)0);
    ((n)localObject).weq = new MobileFriendUI.11(this);
    a((n)localObject);
    boolean bool;
    if (com.tencent.mm.model.a.g.Iy().iX("2") != null)
    {
      localObject = com.tencent.mm.model.a.g.Iy().iX("2").value;
      if (((String)localObject).equals("0"))
      {
        bool = false;
        com.tencent.mm.model.a.f.jb("2");
      }
    }
    for (;;)
    {
      y.i("MicroMsg.MobileFriendUI", "ABTest Type, NEW(%B)", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {}
      for (this.fen = new c(this, new MobileFriendUI.12(this));; this.fen = new d(this, new MobileFriendUI.13(this)))
      {
        this.fem.setAdapter(this.fen);
        this.fem.setOnItemClickListener(new MobileFriendUI.14(this));
        this.fen.a(new MobileFriendUI.15(this));
        if ((l.WP() != l.a.ffT) && (l.WP() != l.a.ffU))
        {
          this.feo = findViewById(a.e.mobile_friend_mobile_not_bind_ll);
          this.feo.setVisibility(0);
          this.feo.setOnClickListener(new MobileFriendUI.2(this));
          this.fem.setVisibility(8);
        }
        setBackBtn(new MobileFriendUI.3(this));
        new MobileFriendUI.4(this);
        if ((!q.GN()) || (l.WO())) {
          com.tencent.mm.ui.base.h.a(this, a.i.bind_mcontact_bind_alert_content, a.i.app_tip, a.i.app_ok, a.i.app_cancel, new MobileFriendUI.5(this), new MobileFriendUI.6(this));
        }
        return;
        if (!((String)localObject).equals("1")) {
          break label392;
        }
        bool = true;
        break;
      }
      label392:
      bool = true;
      break;
      bool = true;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(a.i.mobile_friend_title);
    ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).dXo.gk("qqlist", "update addr_upload2 set reserved4=0");
    com.tencent.mm.kernel.g.Dk().a(32, this);
    com.tencent.mm.kernel.g.Dk().a(133, this);
    initView();
    boolean bool = com.tencent.mm.pluginsdk.permission.a.a(this, "android.permission.READ_CONTACTS", 48, null, null);
    y.i("MicroMsg.MobileFriendUI", "summerper checkPermission checkContacts[%b]", new Object[] { Boolean.valueOf(bool) });
    if (!bool) {
      return;
    }
    getData();
  }
  
  public void onDestroy()
  {
    com.tencent.mm.model.a.f.jc("2");
    com.tencent.mm.kernel.g.Dk().b(32, this);
    com.tencent.mm.kernel.g.Dk().b(133, this);
    this.fen.bcS();
    super.onDestroy();
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    y.i("MicroMsg.MobileFriendUI", "summerper onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    default: 
      return;
    }
    if (paramArrayOfInt[0] == 0)
    {
      getData();
      return;
    }
    com.tencent.mm.ui.base.h.a(this, getString(a.i.permission_contacts_request_again_msg), getString(a.i.permission_tips_title), getString(a.i.jump_to_settings), getString(a.i.app_cancel), false, new MobileFriendUI.1(this), new MobileFriendUI.8(this));
  }
  
  protected void onResume()
  {
    super.onResume();
    this.fen.notifyDataSetChanged();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ah.m paramm)
  {
    y.i("MicroMsg.MobileFriendUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if ((paramm.getType() == 32) && (this.dnm != null))
    {
      this.dnm.dismiss();
      this.dnm = null;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      y.e("MicroMsg.MobileFriendUI", "onSceneEnd: errType = " + paramInt1 + ", errCode = " + paramInt2);
    }
    if (paramm.getType() == 133)
    {
      paramString = new ab();
      com.tencent.mm.kernel.g.Dk().a(paramString, 0);
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramm.getType() == 32) {
        ((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.t(com.tencent.mm.plugin.account.a.a.a.class)).updateAllContact();
      }
      this.fen.a(null, null);
    }
    while (paramm.getType() != 32) {
      return;
    }
    Toast.makeText(this, a.i.mobile_friend_err, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.MobileFriendUI
 * JD-Core Version:    0.7.0.1
 */