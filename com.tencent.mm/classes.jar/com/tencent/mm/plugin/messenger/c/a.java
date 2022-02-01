package com.tencent.mm.plugin.messenger.c;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.d.b;
import com.tencent.mm.plugin.messenger.d.b.b;
import com.tencent.mm.plugin.messenger.d.c;
import com.tencent.mm.plugin.messenger.d.c.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.cdp;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class a
  extends b
  implements f
{
  private ProgressDialog fOC;
  String kEK;
  WeakReference<Context> lZK;
  long msgId;
  com.tencent.mm.plugin.messenger.b.a vWs;
  String vWt;
  String vWu;
  String vWv;
  String vWw;
  String vWx;
  
  public a(b.b paramb)
  {
    super(paramb);
    AppMethodBeat.i(218155);
    this.fOC = null;
    g.ajj().a(3713, this);
    AppMethodBeat.o(218155);
  }
  
  static CharSequence concactSpannable(ArrayList<CharSequence> paramArrayList)
  {
    AppMethodBeat.i(218158);
    SpannableString localSpannableString = new SpannableString("");
    Iterator localIterator = paramArrayList.iterator();
    for (paramArrayList = localSpannableString; localIterator.hasNext(); paramArrayList = TextUtils.concat(new CharSequence[] { paramArrayList, (CharSequence)localIterator.next() })) {}
    AppMethodBeat.o(218158);
    return paramArrayList;
  }
  
  public final CharSequence b(final Map<String, String> paramMap, final String paramString, final Bundle paramBundle, final WeakReference<Context> paramWeakReference, final WeakReference<NeatTextView> paramWeakReference1)
  {
    AppMethodBeat.i(218157);
    if (paramMap == null)
    {
      AppMethodBeat.o(218157);
      return null;
    }
    if (paramBundle != null) {}
    for (final String str1 = paramBundle.getString("conv_talker_username");; str1 = "")
    {
      String str2 = bu.nullAsNil((String)paramMap.get(paramString + ".title"));
      SpannableString localSpannableString = new SpannableString(str2);
      localSpannableString.setSpan(new com.tencent.mm.plugin.messenger.a.a()
      {
        public final void onClickImp(View paramAnonymousView)
        {
          AppMethodBeat.i(218152);
          a.this.msgId = paramBundle.getLong("msg_id");
          a locala = a.this;
          Map localMap = paramMap;
          String str1 = paramString;
          WeakReference localWeakReference = paramWeakReference;
          if (localWeakReference != null) {}
          ArrayList localArrayList;
          c.a locala1;
          do
          {
            try
            {
              if (localWeakReference.get() != null)
              {
                locala.lZK = localWeakReference;
                if ("new_tmpl_type_succeed_contact_window".equals((String)localMap.get(str1 + ".window_template.$type")))
                {
                  locala.vWt = bu.bI((String)localMap.get(str1 + ".window_template.title"), "");
                  locala.vWu = bu.bI((String)localMap.get(str1 + ".window_template.cancel_wording"), "");
                  locala.kEK = bu.bI((String)localMap.get(str1 + ".window_template.confirm_wording"), "");
                  locala.vWv = bu.bI((String)localMap.get(str1 + ".origin_username"), "");
                  locala.vWw = bu.bI((String)localMap.get(str1 + ".heir_username"), "");
                  locala.vWx = bu.bI((String)localMap.get(str1 + ".succeed_ticket"), "");
                  paramAnonymousView = c.arI(locala.vWt);
                  if ((paramAnonymousView == null) || (paramAnonymousView.size() <= 0)) {
                    break label711;
                  }
                  localArrayList = new ArrayList();
                  Iterator localIterator = paramAnonymousView.iterator();
                  for (;;)
                  {
                    if (!localIterator.hasNext()) {
                      break label697;
                    }
                    locala1 = (c.a)localIterator.next();
                    if ((locala1 != null) && (locala1.content != null))
                    {
                      if (locala1.type != 0) {
                        break;
                      }
                      localArrayList.add(new SpannableString(k.c(ak.getContext(), locala1.content)));
                    }
                  }
                }
              }
              ((e)g.ab(e.class)).a("new_link_succeed_contact", paramMap, paramBundle);
            }
            catch (Exception paramAnonymousView)
            {
              ae.e("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "Exception:%s %s", new Object[] { paramAnonymousView.getClass().getSimpleName(), paramAnonymousView.getMessage() });
            }
            AppMethodBeat.o(218152);
            return;
          } while (locala1.type != 1);
          int i = 0;
          for (;;)
          {
            paramAnonymousView = str1 + ".window_template.link_list.link";
            if (i != 0) {
              paramAnonymousView = paramAnonymousView + i;
            }
            for (;;)
            {
              if (bu.isNullOrNil((String)localMap.get(paramAnonymousView))) {
                break label763;
              }
              String str2 = (String)localMap.get(paramAnonymousView + ".$name");
              String str3 = (String)localMap.get(paramAnonymousView + ".$type");
              if ((!locala1.content.equals(str2)) || (!"link_plain".equals(str3))) {
                break label765;
              }
              localArrayList.add(bu.bI((String)localMap.get(paramAnonymousView + ".plain"), ""));
              break label765;
              label697:
              locala.vWt = a.concactSpannable(localArrayList).toString();
              label711:
              locala.fQ((Context)localWeakReference.get());
              locala.vWs = new com.tencent.mm.plugin.messenger.b.a(locala.vWv, locala.vWw, locala.vWx, 1);
              g.ajj().a(locala.vWs, 0);
              break;
            }
            label763:
            break;
            label765:
            i += 1;
          }
        }
      }, 0, str2.length(), 33);
      AppMethodBeat.o(218157);
      return localSpannableString;
    }
  }
  
  public final String dpe()
  {
    return "new_link_succeed_contact";
  }
  
  final void fQ(Context paramContext)
  {
    AppMethodBeat.i(218159);
    if (this.fOC == null)
    {
      paramContext.getString(2131755906);
      this.fOC = h.b(paramContext, paramContext.getString(2131761820), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(218153);
          g.ajj().a(a.this.vWs);
          AppMethodBeat.o(218153);
        }
      });
      AppMethodBeat.o(218159);
      return;
    }
    if (!this.fOC.isShowing()) {
      this.fOC.show();
    }
    AppMethodBeat.o(218159);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(218160);
    ae.i("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "onSceneEnd errType = %d, errCode = %d, errMsg = %s, scenetype:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.getType()) });
    if ((this.fOC != null) && (this.fOC.isShowing())) {
      this.fOC.dismiss();
    }
    if ((paramn instanceof com.tencent.mm.plugin.messenger.b.a))
    {
      if (paramInt2 == -3600)
      {
        new f.a(ak.getContext()).aZq(ak.getContext().getString(2131766240)).afY(2131766205).b(null).show();
        com.tencent.mm.plugin.messenger.e.a.R(this.msgId, 7);
        AppMethodBeat.o(218160);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject = (com.tencent.mm.plugin.messenger.b.a)paramn;
        if (((com.tencent.mm.plugin.messenger.b.a)localObject).vWr == null) {}
        for (localObject = null;; localObject = ((com.tencent.mm.plugin.messenger.b.a)localObject).vWr)
        {
          paramInt1 = ((com.tencent.mm.plugin.messenger.b.a)paramn).action;
          if (localObject == null) {
            break label325;
          }
          ae.i("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "NetSceneOpenImNotAutoSucceed ret:%s action:%s", new Object[] { Integer.valueOf(((cdp)localObject).BaseResponse.Ret), Integer.valueOf(paramInt1) });
          if (paramInt1 != 1) {
            break label319;
          }
          if ((this.lZK != null) && (this.lZK.get() != null)) {
            break;
          }
          ae.e("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "NOT_AUTO_SUCCEED_ACTION_PREPARE context == null");
          AppMethodBeat.o(218160);
          return;
        }
        paramString = new f.a((Context)this.lZK.get());
        paramString.zi(false);
        paramString.aZq(this.vWt).aZv(this.vWu).aZu(this.kEK).c(new f.c()
        {
          public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
          {
            AppMethodBeat.i(218154);
            ae.i("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "click %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
            if (paramAnonymousBoolean)
            {
              if ((a.this.lZK == null) || (a.this.lZK.get() == null))
              {
                ae.e("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "onDialogClick context == null");
                AppMethodBeat.o(218154);
                return;
              }
              paramAnonymousString = (Context)a.this.lZK.get();
              a.this.vWs = new com.tencent.mm.plugin.messenger.b.a(a.this.vWv, a.this.vWw, a.this.vWx, 2);
              g.ajj().a(a.this.vWs, 0);
              a.this.fQ(paramAnonymousString);
              com.tencent.mm.plugin.messenger.e.a.R(a.this.msgId, 9);
              AppMethodBeat.o(218154);
              return;
            }
            com.tencent.mm.plugin.messenger.e.a.R(a.this.msgId, 10);
            AppMethodBeat.o(218154);
          }
        }).show();
        com.tencent.mm.plugin.messenger.e.a.R(this.msgId, 8);
        label319:
        AppMethodBeat.o(218160);
        return;
        label325:
        ae.e("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "notAutoSucceedResp is null");
      }
      Object localObject = ak.getContext();
      paramn = paramString;
      if (bu.isNullOrNil(paramString)) {
        paramn = ak.getContext().getString(2131755733);
      }
      t.makeText((Context)localObject, paramn, 0).show();
      com.tencent.mm.plugin.messenger.e.a.R(this.msgId, 6);
    }
    AppMethodBeat.o(218160);
  }
  
  public final void release()
  {
    AppMethodBeat.i(218156);
    super.release();
    g.ajj().b(3713, this);
    AppMethodBeat.o(218156);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.c.a
 * JD-Core Version:    0.7.0.1
 */