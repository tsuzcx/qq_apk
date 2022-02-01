package com.tencent.mm.plugin.emoji.ui.v3.a;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.bw;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.g.e;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.emoji.model.p;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.cjb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;
import java.util.ArrayList;

public final class n
{
  public static e xNs;
  private final String TAG;
  private Context mAppContext;
  public cjb xHE;
  public boolean xNk;
  public Context xNl;
  public Fragment xNm;
  public int xNn;
  public long xNo;
  public String xNp;
  public String xNr;
  public String xNt;
  public bw xNu;
  public boolean xNv;
  public p ybU;
  public w yct;
  public a ycu;
  
  static
  {
    AppMethodBeat.i(270691);
    xNs = new e(2003);
    AppMethodBeat.o(270691);
  }
  
  public n()
  {
    AppMethodBeat.i(270678);
    this.TAG = "MicroMsg.emoji.EmojiStoreV3PayOrDownloadComponent";
    this.xNk = false;
    this.xNo = 0L;
    this.xNp = "";
    this.xNv = false;
    this.mAppContext = MMApplicationContext.getContext();
    AppMethodBeat.o(270678);
  }
  
  private void aoJ(String paramString)
  {
    AppMethodBeat.i(270688);
    String str = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str = getString(h.h.emoji_play_failed);
    }
    k.d(this.xNl, str, "", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(270688);
  }
  
  public final String getString(int paramInt)
  {
    AppMethodBeat.i(270717);
    String str = this.mAppContext.getString(paramInt);
    AppMethodBeat.o(270717);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(270713);
    Log.d("MicroMsg.emoji.EmojiStoreV3PayOrDownloadComponent", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    String str1 = "";
    int i = 0;
    if (paramIntent != null)
    {
      i = paramIntent.getIntExtra("key_err_code", 0);
      Log.w("MicroMsg.emoji.EmojiStoreV3PayOrDownloadComponent", "errCode:".concat(String.valueOf(i)));
      str1 = paramIntent.getStringExtra("key_err_msg");
      Log.w("MicroMsg.emoji.EmojiStoreV3PayOrDownloadComponent", "errMsg:".concat(String.valueOf(str1)));
    }
    this.xNk = false;
    if (paramInt2 != -1)
    {
      if (paramInt1 == 2001)
      {
        if (z.bBh())
        {
          h.OAn.idkeyStat(166L, 6L, 1L, false);
          AppMethodBeat.o(270713);
          return;
        }
        h.OAn.idkeyStat(166L, 2L, 1L, false);
      }
      AppMethodBeat.o(270713);
      return;
    }
    switch (paramInt1)
    {
    case 2002: 
    default: 
      Log.e("MicroMsg.emoji.EmojiStoreV3PayOrDownloadComponent", "onActivityResult unknow request");
      AppMethodBeat.o(270713);
      return;
    case 2003: 
      str1 = xNs.ydM;
      if (Util.isNullOrNil(str1))
      {
        AppMethodBeat.o(270713);
        return;
      }
      xNs.a(paramIntent, str1, (Activity)this.xNl);
      h.OAn.b(12069, new Object[] { Integer.valueOf(3), str1 });
      AppMethodBeat.o(270713);
      return;
    }
    if ((paramIntent != null) && (i == 0))
    {
      ArrayList localArrayList = paramIntent.getStringArrayListExtra("key_response_product_ids");
      paramIntent = paramIntent.getStringArrayListExtra("key_response_series_ids");
      paramInt1 = 0;
      i = localArrayList.size();
      paramInt2 = 0;
      if (paramInt2 < i)
      {
        String str2 = (String)localArrayList.get(paramInt2);
        String str3 = (String)paramIntent.get(paramInt2);
        if (this.xNr.equals(str2))
        {
          if (this.xHE != null)
          {
            String str4 = this.xHE.akkk;
            r(str2, str3, this.xHE.Zul, str4);
          }
          this.yct.bg(0, this.xNr);
          k.cZ(this.xNl, str1);
          Log.i("MicroMsg.emoji.EmojiStoreV3PayOrDownloadComponent", "doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { str2 });
          if (localArrayList.size() > 1)
          {
            Log.i("MicroMsg.emoji.EmojiStoreV3PayOrDownloadComponent", "some other product verify.");
            if (this.ycu != null) {
              this.ycu.dCN();
            }
          }
          paramInt1 = 1;
        }
        for (;;)
        {
          paramInt2 += 1;
          break;
          this.yct.bg(5, this.xNr);
        }
      }
      if (paramInt1 == 0) {
        aoJ(str1);
      }
      if (z.bBh())
      {
        h.OAn.idkeyStat(166L, 4L, 1L, false);
        AppMethodBeat.o(270713);
        return;
      }
      h.OAn.idkeyStat(166L, 0L, 1L, false);
      AppMethodBeat.o(270713);
      return;
    }
    if ((paramIntent != null) && (i == 100000002))
    {
      if (this.xHE != null)
      {
        paramIntent = this.xHE.akkk;
        r(this.xNr, null, this.yct.dDd().xHE.Zul, paramIntent);
        this.yct.bg(0, this.xNr);
      }
      Log.i("MicroMsg.emoji.EmojiStoreV3PayOrDownloadComponent", "emoji has paied. now doScene ExchangeEmotionPackNetScene productId:%s", new Object[] { this.xNr });
      aoJ(str1);
      if (z.bBh())
      {
        h.OAn.idkeyStat(166L, 7L, 1L, false);
        AppMethodBeat.o(270713);
        return;
      }
      h.OAn.idkeyStat(166L, 3L, 1L, false);
      AppMethodBeat.o(270713);
      return;
    }
    if ((paramIntent != null) && (i == 1))
    {
      if (z.bBh()) {
        h.OAn.idkeyStat(166L, 6L, 1L, false);
      }
      for (;;)
      {
        Log.i("MicroMsg.emoji.EmojiStoreV3PayOrDownloadComponent", "user cancel pay emoji.");
        AppMethodBeat.o(270713);
        return;
        h.OAn.idkeyStat(166L, 2L, 1L, false);
      }
    }
    paramIntent = this.xNr;
    if (paramIntent != null)
    {
      this.yct.anO(paramIntent);
      this.yct.dye();
    }
    aoJ(str1);
    if (z.bBh()) {
      h.OAn.idkeyStat(166L, 5L, 1L, false);
    }
    for (;;)
    {
      Log.i("MicroMsg.emoji.EmojiStoreV3PayOrDownloadComponent", "failed pay emoji. errormsg:%s", new Object[] { str1 });
      AppMethodBeat.o(270713);
      return;
      h.OAn.idkeyStat(166L, 1L, 1L, false);
    }
  }
  
  public final void r(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(270698);
    if (this.ycu != null) {
      this.ycu.r(paramString1, paramString2, paramString3, paramString4);
    }
    AppMethodBeat.o(270698);
  }
  
  public static abstract interface a
  {
    public abstract void dCN();
    
    public abstract void r(String paramString1, String paramString2, String paramString3, String paramString4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v3.a.n
 * JD-Core Version:    0.7.0.1
 */