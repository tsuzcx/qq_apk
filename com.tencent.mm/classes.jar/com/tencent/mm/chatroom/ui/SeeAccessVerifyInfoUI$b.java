package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.at.a.a;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.at.o;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.openim.PluginOpenIM;
import com.tencent.mm.openim.b.i;
import com.tencent.mm.openim.e.e;
import com.tencent.mm.openim.e.f;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class SeeAccessVerifyInfoUI$b
  extends BaseAdapter
{
  List<SeeAccessVerifyInfoUI.a> eiJ;
  private c eiK;
  Context mContext;
  
  public SeeAccessVerifyInfoUI$b(SeeAccessVerifyInfoUI paramSeeAccessVerifyInfoUI, Context paramContext)
  {
    AppMethodBeat.i(104268);
    this.eiJ = new ArrayList();
    this.eiK = null;
    this.mContext = paramContext;
    Ke();
    paramSeeAccessVerifyInfoUI = new c.a();
    paramSeeAccessVerifyInfoUI.eNM = true;
    paramSeeAccessVerifyInfoUI.eOe = true;
    paramSeeAccessVerifyInfoUI.eNY = 2131231207;
    this.eiK = paramSeeAccessVerifyInfoUI.ahY();
    AppMethodBeat.o(104268);
  }
  
  private void Ke()
  {
    AppMethodBeat.i(104269);
    String[] arrayOfString5;
    String[] arrayOfString1;
    String[] arrayOfString2;
    label111:
    String[] arrayOfString3;
    label138:
    int i;
    label149:
    List localList;
    SeeAccessVerifyInfoUI localSeeAccessVerifyInfoUI;
    String str5;
    String str1;
    label197:
    String str2;
    label220:
    String str3;
    if (!bo.isNullOrNil(SeeAccessVerifyInfoUI.l(this.eiF)))
    {
      String[] arrayOfString4 = SeeAccessVerifyInfoUI.l(this.eiF).split(",");
      if (bo.isNullOrNil(SeeAccessVerifyInfoUI.n(this.eiF))) {
        break label316;
      }
      arrayOfString5 = SeeAccessVerifyInfoUI.n(this.eiF).split(",");
      if (bo.isNullOrNil(SeeAccessVerifyInfoUI.o(this.eiF))) {
        break label329;
      }
      arrayOfString1 = SeeAccessVerifyInfoUI.o(this.eiF).split(",");
      if (bo.isNullOrNil(SeeAccessVerifyInfoUI.p(this.eiF))) {
        break label341;
      }
      arrayOfString2 = SeeAccessVerifyInfoUI.p(this.eiF).split(",");
      if (bo.isNullOrNil(SeeAccessVerifyInfoUI.q(this.eiF))) {
        break label353;
      }
      arrayOfString3 = SeeAccessVerifyInfoUI.q(this.eiF).split(",");
      this.eiJ.clear();
      i = 0;
      if (i >= arrayOfString4.length) {
        break label400;
      }
      localList = this.eiJ;
      localSeeAccessVerifyInfoUI = this.eiF;
      str5 = arrayOfString4[i];
      if ((arrayOfString5.length > i) && (!bo.isNullOrNil(arrayOfString5[i]))) {
        break label366;
      }
      str1 = arrayOfString4[i];
      if ((arrayOfString1 != null) && (arrayOfString1.length > i) && (!bo.isNullOrNil(arrayOfString1[i]))) {
        break label375;
      }
      str2 = "";
      if ((arrayOfString2 != null) && (arrayOfString2.length > i) && (!bo.isNullOrNil(arrayOfString2[i]))) {
        break label383;
      }
      str3 = "";
      label243:
      if ((arrayOfString3 != null) && (arrayOfString3.length > i) && (!bo.isNullOrNil(arrayOfString3[i]))) {
        break label391;
      }
    }
    label391:
    for (String str4 = "";; str4 = arrayOfString3[i])
    {
      localList.add(new SeeAccessVerifyInfoUI.a(localSeeAccessVerifyInfoUI, str5, str1, str2, str3, str4));
      i += 1;
      break label149;
      ab.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesUsernames null");
      AppMethodBeat.o(104269);
      return;
      label316:
      ab.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesNicknames null");
      AppMethodBeat.o(104269);
      return;
      label329:
      ab.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesAppids null");
      arrayOfString1 = null;
      break;
      label341:
      ab.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesDescids null");
      arrayOfString2 = null;
      break label111;
      label353:
      ab.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesHeadimgurls null");
      arrayOfString3 = null;
      break label138;
      label366:
      str1 = arrayOfString5[i];
      break label197;
      label375:
      str2 = arrayOfString1[i];
      break label220;
      label383:
      str3 = arrayOfString2[i];
      break label243;
    }
    label400:
    AppMethodBeat.o(104269);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(104270);
    int i = this.eiJ.size();
    AppMethodBeat.o(104270);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(104271);
    Object localObject = this.eiJ.get(paramInt);
    AppMethodBeat.o(104271);
    return localObject;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(104272);
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, 2130970591, null);
      paramViewGroup = this.eiF.ci(paramView);
    }
    label477:
    for (;;)
    {
      paramViewGroup.egq.setVisibility(0);
      paramViewGroup.eiM.setVisibility(0);
      o.ahG().a(((SeeAccessVerifyInfoUI.a)this.eiJ.get(paramInt)).eiI, paramViewGroup.egq, this.eiK);
      paramViewGroup.eiM.setText(j.b(this.mContext, bo.nullAsNil(((SeeAccessVerifyInfoUI.a)this.eiJ.get(paramInt)).nickname), paramViewGroup.eiM.getTextSize()));
      e locale;
      if (ad.arf(((SeeAccessVerifyInfoUI.a)this.eiJ.get(paramInt)).username))
      {
        SeeAccessVerifyInfoUI.r(this.eiF);
        locale = new e();
        locale.field_appid = bo.nullAsNil(((SeeAccessVerifyInfoUI.a)this.eiJ.get(paramInt)).cwc);
        locale.field_wordingId = bo.nullAsNil(((SeeAccessVerifyInfoUI.a)this.eiJ.get(paramInt)).eiH);
        locale.field_language = aa.gP(ah.getContext());
        g.RM();
        ((PluginOpenIM)g.G(PluginOpenIM.class)).getWordingInfoStg().get(locale, new String[] { "appid", "wordingId", "language" });
        if (!TextUtils.isEmpty(locale.field_wording))
        {
          paramViewGroup.eiN.setVisibility(0);
          paramViewGroup.eiN.setText("＠" + locale.field_wording);
        }
      }
      for (;;)
      {
        paramView.setOnClickListener(new SeeAccessVerifyInfoUI.b.1(this, paramInt));
        AppMethodBeat.o(104272);
        return paramView;
        paramViewGroup = (SeeAccessVerifyInfoUI.c)paramView.getTag();
        if (paramViewGroup != null) {
          break label477;
        }
        paramViewGroup = this.eiF.ci(paramView);
        break;
        if ((!bo.isNullOrNil(locale.field_appid)) && (!bo.isNullOrNil(locale.field_wordingId)))
        {
          LinkedList localLinkedList = new LinkedList();
          localLinkedList.add(locale.field_wordingId);
          if (!bo.z(paramViewGroup.eiN.getTag(), "first"))
          {
            SeeAccessVerifyInfoUI.s(this.eiF);
            g.RK().eHt.a(new i(locale.field_appid, locale.field_language, localLinkedList), 0);
          }
        }
        paramViewGroup.eiN.setVisibility(4);
        paramViewGroup.eiN.setTag("first");
        continue;
        paramViewGroup.eiN.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI.b
 * JD-Core Version:    0.7.0.1
 */