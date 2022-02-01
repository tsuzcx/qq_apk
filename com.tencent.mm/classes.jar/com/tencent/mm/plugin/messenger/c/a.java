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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.messenger.a.f;
import com.tencent.mm.plugin.messenger.d.b;
import com.tencent.mm.plugin.messenger.d.b.b;
import com.tencent.mm.plugin.messenger.d.c;
import com.tencent.mm.plugin.messenger.d.c.a;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.btn;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
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
  implements com.tencent.mm.al.g
{
  private ProgressDialog fpP;
  String jGj;
  WeakReference<Context> kUk;
  long msgId;
  com.tencent.mm.plugin.messenger.b.a tyO;
  String tyP;
  String tyQ;
  String tyR;
  String tyS;
  String tyT;
  
  public a(b.b paramb)
  {
    super(paramb);
    AppMethodBeat.i(196712);
    this.fpP = null;
    com.tencent.mm.kernel.g.aeS().a(3713, this);
    AppMethodBeat.o(196712);
  }
  
  static CharSequence concactSpannable(ArrayList<CharSequence> paramArrayList)
  {
    AppMethodBeat.i(196715);
    SpannableString localSpannableString = new SpannableString("");
    Iterator localIterator = paramArrayList.iterator();
    for (paramArrayList = localSpannableString; localIterator.hasNext(); paramArrayList = TextUtils.concat(new CharSequence[] { paramArrayList, (CharSequence)localIterator.next() })) {}
    AppMethodBeat.o(196715);
    return paramArrayList;
  }
  
  public final CharSequence b(final Map<String, String> paramMap, final String paramString, final Bundle paramBundle, final WeakReference<Context> paramWeakReference, final WeakReference<NeatTextView> paramWeakReference1)
  {
    AppMethodBeat.i(196714);
    if (paramMap == null)
    {
      AppMethodBeat.o(196714);
      return null;
    }
    if (paramBundle != null) {}
    for (final String str1 = paramBundle.getString("conv_talker_username");; str1 = "")
    {
      String str2 = bt.nullAsNil((String)paramMap.get(paramString + ".title"));
      SpannableString localSpannableString = new SpannableString(str2);
      localSpannableString.setSpan(new com.tencent.mm.plugin.messenger.a.a()
      {
        public final void onClickImp(View paramAnonymousView)
        {
          AppMethodBeat.i(196709);
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
                locala.kUk = localWeakReference;
                if ("new_tmpl_type_succeed_contact_window".equals((String)localMap.get(str1 + ".window_template.$type")))
                {
                  locala.tyP = bt.by((String)localMap.get(str1 + ".window_template.title"), "");
                  locala.tyQ = bt.by((String)localMap.get(str1 + ".window_template.cancel_wording"), "");
                  locala.jGj = bt.by((String)localMap.get(str1 + ".window_template.confirm_wording"), "");
                  locala.tyR = bt.by((String)localMap.get(str1 + ".origin_username"), "");
                  locala.tyS = bt.by((String)localMap.get(str1 + ".heir_username"), "");
                  locala.tyT = bt.by((String)localMap.get(str1 + ".succeed_ticket"), "");
                  paramAnonymousView = c.agU(locala.tyP);
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
                      localArrayList.add(new SpannableString(k.c(aj.getContext(), locala1.content)));
                    }
                  }
                }
              }
              ((f)com.tencent.mm.kernel.g.ab(f.class)).a("new_link_succeed_contact", paramMap, paramBundle);
            }
            catch (Exception paramAnonymousView)
            {
              ad.e("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "Exception:%s %s", new Object[] { paramAnonymousView.getClass().getSimpleName(), paramAnonymousView.getMessage() });
            }
            AppMethodBeat.o(196709);
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
              if (bt.isNullOrNil((String)localMap.get(paramAnonymousView))) {
                break label763;
              }
              String str2 = (String)localMap.get(paramAnonymousView + ".$name");
              String str3 = (String)localMap.get(paramAnonymousView + ".$type");
              if ((!locala1.content.equals(str2)) || (!"link_plain".equals(str3))) {
                break label765;
              }
              localArrayList.add(bt.by((String)localMap.get(paramAnonymousView + ".plain"), ""));
              break label765;
              label697:
              locala.tyP = a.concactSpannable(localArrayList).toString();
              label711:
              locala.tyO = new com.tencent.mm.plugin.messenger.b.a(locala.tyR, locala.tyS, locala.tyT, 1);
              com.tencent.mm.kernel.g.aeS().a(locala.tyO, 0);
              locala.ft((Context)localWeakReference.get());
              break;
            }
            label763:
            break;
            label765:
            i += 1;
          }
        }
      }, 0, str2.length(), 33);
      AppMethodBeat.o(196714);
      return localSpannableString;
    }
  }
  
  public final String cPc()
  {
    return "new_link_succeed_contact";
  }
  
  final void ft(Context paramContext)
  {
    AppMethodBeat.i(196716);
    if (this.fpP == null)
    {
      paramContext.getString(2131755906);
      this.fpP = h.b(paramContext, paramContext.getString(2131761820), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(196710);
          com.tencent.mm.kernel.g.aeS().a(a.this.tyO);
          AppMethodBeat.o(196710);
        }
      });
      AppMethodBeat.o(196716);
      return;
    }
    if (!this.fpP.isShowing()) {
      this.fpP.show();
    }
    AppMethodBeat.o(196716);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(196717);
    ad.i("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "onSceneEnd errType = %d, errCode = %d, errMsg = %s, scenetype:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramn.getType()) });
    if ((this.fpP != null) && (this.fpP.isShowing())) {
      this.fpP.dismiss();
    }
    if ((paramn instanceof com.tencent.mm.plugin.messenger.b.a))
    {
      if (paramInt2 == -3600)
      {
        new f.a(aj.getContext()).aMo(aj.getContext().getString(2131766240)).aaF(2131766205).b(null).show();
        com.tencent.mm.plugin.messenger.e.a.K(this.msgId, 7);
        AppMethodBeat.o(196717);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject = (com.tencent.mm.plugin.messenger.b.a)paramn;
        if (((com.tencent.mm.plugin.messenger.b.a)localObject).tyN == null) {}
        for (localObject = null;; localObject = ((com.tencent.mm.plugin.messenger.b.a)localObject).tyN)
        {
          paramInt1 = ((com.tencent.mm.plugin.messenger.b.a)paramn).action;
          if (localObject == null) {
            break;
          }
          ad.i("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "NetSceneOpenImNotAutoSucceed ret:%s action:%s", new Object[] { Integer.valueOf(((btn)localObject).BaseResponse.Ret), Integer.valueOf(paramInt1) });
          if (paramInt1 == 1)
          {
            paramString = new f.a((Context)this.kUk.get());
            paramString.wZ(false);
            paramString.aMo(this.tyP).aMt(this.tyQ).aMs(this.jGj).c(new f.c()
            {
              public final void d(boolean paramAnonymousBoolean, String paramAnonymousString)
              {
                AppMethodBeat.i(196711);
                ad.i("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "click %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
                if (paramAnonymousBoolean)
                {
                  if ((a.this.kUk == null) || (a.this.kUk.get() == null))
                  {
                    ad.e("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "onDialogClick context == null");
                    AppMethodBeat.o(196711);
                    return;
                  }
                  paramAnonymousString = (Context)a.this.kUk.get();
                  a.this.tyO = new com.tencent.mm.plugin.messenger.b.a(a.this.tyR, a.this.tyS, a.this.tyT, 2);
                  com.tencent.mm.kernel.g.aeS().a(a.this.tyO, 0);
                  a.this.ft(paramAnonymousString);
                  com.tencent.mm.plugin.messenger.e.a.K(a.this.msgId, 9);
                  AppMethodBeat.o(196711);
                  return;
                }
                com.tencent.mm.plugin.messenger.e.a.K(a.this.msgId, 10);
                AppMethodBeat.o(196711);
              }
            }).show();
            com.tencent.mm.plugin.messenger.e.a.K(this.msgId, 8);
          }
          AppMethodBeat.o(196717);
          return;
        }
        ad.e("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "notAutoSucceedResp is null");
      }
      Object localObject = aj.getContext();
      paramn = paramString;
      if (bt.isNullOrNil(paramString)) {
        paramn = aj.getContext().getString(2131755733);
      }
      t.makeText((Context)localObject, paramn, 0).show();
      com.tencent.mm.plugin.messenger.e.a.K(this.msgId, 6);
    }
    AppMethodBeat.o(196717);
  }
  
  public final void release()
  {
    AppMethodBeat.i(196713);
    super.release();
    com.tencent.mm.kernel.g.aeS().b(3713, this);
    AppMethodBeat.o(196713);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.c.a
 * JD-Core Version:    0.7.0.1
 */