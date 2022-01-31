package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.a.e;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.friend.a.al;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.plugin.account.friend.a.l.a;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.q;
import java.util.List;

public class MobileFriendUI
  extends MMActivity
  implements com.tencent.mm.ai.f
{
  private ProgressDialog eeN = null;
  private TextView emptyTipTv = null;
  private ListView gvV;
  b gvW;
  private View gvX;
  private al gvY;
  String gvZ;
  private TextView gwa = null;
  
  private void apS()
  {
    AppMethodBeat.i(13735);
    if (com.tencent.luggage.g.b.fv(26))
    {
      boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.WRITE_CONTACTS", 48, null, null);
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MobileFriendUI", "onCreateAfterMPermissionGranted() checkContacts(android.Manifest.permission.WRITE_CONTACTS)[%b]", new Object[] { Boolean.valueOf(bool) });
      if (!bool)
      {
        AppMethodBeat.o(13735);
        return;
      }
    }
    getData();
    AppMethodBeat.o(13735);
  }
  
  private void getData()
  {
    AppMethodBeat.i(13737);
    if (!l.aqp())
    {
      Object localObject = getContext();
      getString(2131297087);
      this.eeN = com.tencent.mm.ui.base.h.b((Context)localObject, getString(2131301579), true, new MobileFriendUI.9(this));
      if (this.gvW.getCount() == 0)
      {
        if ((!((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.account.a.a.a.class)).syncAddrBook(new MobileFriendUI.10(this))) && (this.eeN != null))
        {
          this.eeN.dismiss();
          this.eeN = null;
        }
        AppMethodBeat.o(13737);
        return;
      }
      localObject = l.aqz();
      List localList = l.aqy();
      if ((((List)localObject).size() != 0) || (localList.size() != 0))
      {
        this.gvY = new al(l.aqz(), l.aqy());
        com.tencent.mm.kernel.g.Rc().a(this.gvY, 0);
        AppMethodBeat.o(13737);
        return;
      }
      localObject = new com.tencent.mm.plugin.account.friend.a.ab();
      com.tencent.mm.kernel.g.Rc().a((m)localObject, 0);
    }
    AppMethodBeat.o(13737);
  }
  
  public final void b(com.tencent.mm.plugin.account.friend.a.a parama)
  {
    AppMethodBeat.i(13742);
    if (bo.isNullOrNil(parama.getUsername()))
    {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.MobileFriendUI", "username is null");
      AppMethodBeat.o(13742);
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("Contact_User", parama.getUsername());
    localIntent.putExtra("Contact_Nick", parama.aqc());
    localIntent.putExtra("Contact_Mobile_MD5", parama.Al());
    localIntent.putExtra("Contact_Alias", parama.gwU);
    localIntent.putExtra("Contact_Sex", parama.gwP);
    localIntent.putExtra("Contact_Signature", parama.gwS);
    localIntent.putExtra("Contact_RegionCode", RegionCodeDecoder.aF(parama.gwY, parama.gwQ, parama.gwR));
    localIntent.putExtra("Contact_Scene", 13);
    localIntent.putExtra("Contact_ShowUserName", false);
    com.tencent.mm.plugin.account.a.a.gmO.c(localIntent, this);
    AppMethodBeat.o(13742);
  }
  
  public int getLayoutId()
  {
    return 2130970289;
  }
  
  public void initView()
  {
    AppMethodBeat.i(13741);
    this.emptyTipTv = ((TextView)findViewById(2131824142));
    this.emptyTipTv.setText(2131301577);
    this.gwa = ((TextView)findViewById(2131824143));
    this.gwa.setText(2131301596);
    this.gvX = findViewById(2131824130);
    this.gvV = ((ListView)findViewById(2131824128));
    Object localObject = new q((byte)0);
    ((q)localObject).Axg = new MobileFriendUI.11(this);
    addSearchMenu(true, (q)localObject);
    boolean bool;
    if (com.tencent.mm.model.a.g.abw().pL("2") != null)
    {
      localObject = com.tencent.mm.model.a.g.abw().pL("2").value;
      if (((String)localObject).equals("0"))
      {
        bool = false;
        com.tencent.mm.model.a.f.pP("2");
      }
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MobileFriendUI", "ABTest Type, NEW(%B)", new Object[] { Boolean.valueOf(bool) });
      if (!bool) {}
      for (this.gvW = new c(this, new MobileFriendUI.12(this));; this.gvW = new d(this, new MobileFriendUI.13(this)))
      {
        this.gvV.setAdapter(this.gvW);
        this.gvV.setOnItemClickListener(new MobileFriendUI.14(this));
        this.gvW.a(new MobileFriendUI.15(this));
        if ((l.aqq() != l.a.gxB) && (l.aqq() != l.a.gxC))
        {
          this.gvX = findViewById(2131824130);
          this.gvX.setVisibility(0);
          this.gvX.setOnClickListener(new MobileFriendUI.2(this));
          this.gvV.setVisibility(8);
        }
        setBackBtn(new MobileFriendUI.3(this));
        setToTop(new MobileFriendUI.4(this));
        if ((!r.ZR()) || (l.aqp())) {
          com.tencent.mm.ui.base.h.a(this, 2131297553, 2131297087, 2131297018, 2131296888, new MobileFriendUI.5(this), new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
            {
              AppMethodBeat.i(13724);
              l.dx(false);
              ((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.account.a.a.a.class)).syncUploadMContactStatus(false, true);
              MobileFriendUI.this.finish();
              AppMethodBeat.o(13724);
            }
          });
        }
        AppMethodBeat.o(13741);
        return;
        if (!((String)localObject).equals("1")) {
          break label407;
        }
        bool = true;
        break;
      }
      label407:
      bool = true;
      break;
      bool = true;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(13734);
    super.onCreate(paramBundle);
    setMMTitle(2131301581);
    ((com.tencent.mm.plugin.account.friend.a.b)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.account.a.a.a.class)).getAddrUploadStg()).fnw.execSQL("qqlist", "update addr_upload2 set reserved4=0");
    com.tencent.mm.kernel.g.Rc().a(32, this);
    com.tencent.mm.kernel.g.Rc().a(133, this);
    initView();
    boolean bool = com.tencent.mm.pluginsdk.permission.b.a(this, "android.permission.READ_CONTACTS", 48, null, null);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MobileFriendUI", "summerper checkPermission checkContacts(android.Manifest.permission.READ_CONTACTS)[%b]", new Object[] { Boolean.valueOf(bool) });
    if (!bool)
    {
      AppMethodBeat.o(13734);
      return;
    }
    apS();
    AppMethodBeat.o(13734);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(13740);
    com.tencent.mm.model.a.f.pQ("2");
    com.tencent.mm.kernel.g.Rc().b(32, this);
    com.tencent.mm.kernel.g.Rc().b(133, this);
    this.gvW.bKb();
    super.onDestroy();
    AppMethodBeat.o(13740);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(13739);
    super.onPause();
    AppMethodBeat.o(13739);
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(13736);
    if ((paramArrayOfInt == null) || (paramArrayOfInt.length <= 0))
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MobileFriendUI", "onRequestPermissionsResult grantResults length 0. requestCode[%d], tid[%d]", new Object[] { Integer.valueOf(paramInt), Long.valueOf(Thread.currentThread().getId()) });
      AppMethodBeat.o(13736);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MobileFriendUI", "onRequestPermissionsResult requestCode[%d],grantResults[%d] tid[%d]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(paramArrayOfInt[0]), Long.valueOf(Thread.currentThread().getId()) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(13736);
      return;
      if (paramArrayOfInt[0] == 0)
      {
        apS();
        AppMethodBeat.o(13736);
        return;
      }
      com.tencent.mm.ui.base.h.a(this, getString(2131302069), getString(2131302083), getString(2131300996), getString(2131296888), false, new MobileFriendUI.1(this), new MobileFriendUI.8(this));
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(13738);
    super.onResume();
    this.gvW.notifyDataSetChanged();
    AppMethodBeat.o(13738);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(13743);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.MobileFriendUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if ((paramm.getType() == 32) && (this.eeN != null))
    {
      this.eeN.dismiss();
      this.eeN = null;
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.MobileFriendUI", "onSceneEnd: errType = " + paramInt1 + ", errCode = " + paramInt2);
    }
    if (paramm.getType() == 133)
    {
      paramString = new com.tencent.mm.plugin.account.friend.a.ab();
      com.tencent.mm.kernel.g.Rc().a(paramString, 0);
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramm.getType() == 32) {
        ((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.account.a.a.a.class)).updateAllContact();
      }
      this.gvW.a(null, null);
      AppMethodBeat.o(13743);
      return;
    }
    if (paramm.getType() == 32) {
      Toast.makeText(this, 2131301578, 0).show();
    }
    AppMethodBeat.o(13743);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.MobileFriendUI
 * JD-Core Version:    0.7.0.1
 */