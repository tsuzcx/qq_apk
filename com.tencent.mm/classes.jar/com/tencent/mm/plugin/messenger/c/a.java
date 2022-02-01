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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.a.e;
import com.tencent.mm.plugin.messenger.d.b;
import com.tencent.mm.plugin.messenger.d.b.b;
import com.tencent.mm.plugin.messenger.d.c;
import com.tencent.mm.plugin.messenger.d.c.a;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ctv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public final class a
  extends b
  implements i
{
  private ProgressDialog gtM;
  String lJj;
  long msgId;
  WeakReference<Context> nhy;
  String zqA;
  String zqB;
  String zqC;
  com.tencent.mm.plugin.messenger.b.a zqx;
  String zqy;
  String zqz;
  
  public a(b.b paramb)
  {
    super(paramb);
    AppMethodBeat.i(194484);
    this.gtM = null;
    g.azz().a(3713, this);
    AppMethodBeat.o(194484);
  }
  
  static CharSequence concactSpannable(ArrayList<CharSequence> paramArrayList)
  {
    AppMethodBeat.i(194487);
    SpannableString localSpannableString = new SpannableString("");
    Iterator localIterator = paramArrayList.iterator();
    for (paramArrayList = localSpannableString; localIterator.hasNext(); paramArrayList = TextUtils.concat(new CharSequence[] { paramArrayList, (CharSequence)localIterator.next() })) {}
    AppMethodBeat.o(194487);
    return paramArrayList;
  }
  
  public final CharSequence b(final Map<String, String> paramMap, final String paramString, final Bundle paramBundle, final WeakReference<Context> paramWeakReference, final WeakReference<NeatTextView> paramWeakReference1)
  {
    AppMethodBeat.i(194486);
    if (paramMap == null)
    {
      AppMethodBeat.o(194486);
      return null;
    }
    if (paramBundle != null) {}
    for (final String str1 = paramBundle.getString("conv_talker_username");; str1 = "")
    {
      String str2 = Util.nullAsNil((String)paramMap.get(paramString + ".title"));
      SpannableString localSpannableString = new SpannableString(str2);
      localSpannableString.setSpan(new com.tencent.mm.plugin.messenger.a.a()
      {
        public final void onClickImp(View paramAnonymousView)
        {
          AppMethodBeat.i(194481);
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
                locala.nhy = localWeakReference;
                if ("new_tmpl_type_succeed_contact_window".equals((String)localMap.get(str1 + ".window_template.$type")))
                {
                  locala.zqy = Util.nullAs((String)localMap.get(str1 + ".window_template.title"), "");
                  locala.zqz = Util.nullAs((String)localMap.get(str1 + ".window_template.cancel_wording"), "");
                  locala.lJj = Util.nullAs((String)localMap.get(str1 + ".window_template.confirm_wording"), "");
                  locala.zqA = Util.nullAs((String)localMap.get(str1 + ".origin_username"), "");
                  locala.zqB = Util.nullAs((String)localMap.get(str1 + ".heir_username"), "");
                  locala.zqC = Util.nullAs((String)localMap.get(str1 + ".succeed_ticket"), "");
                  paramAnonymousView = c.aFd(locala.zqy);
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
                      localArrayList.add(new SpannableString(l.c(MMApplicationContext.getContext(), locala1.content)));
                    }
                  }
                }
              }
              ((e)g.af(e.class)).a("new_link_succeed_contact", paramMap, paramBundle);
            }
            catch (Exception paramAnonymousView)
            {
              Log.e("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "Exception:%s %s", new Object[] { paramAnonymousView.getClass().getSimpleName(), paramAnonymousView.getMessage() });
            }
            AppMethodBeat.o(194481);
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
              if (Util.isNullOrNil((String)localMap.get(paramAnonymousView))) {
                break label763;
              }
              String str2 = (String)localMap.get(paramAnonymousView + ".$name");
              String str3 = (String)localMap.get(paramAnonymousView + ".$type");
              if ((!locala1.content.equals(str2)) || (!"link_plain".equals(str3))) {
                break label765;
              }
              localArrayList.add(Util.nullAs((String)localMap.get(paramAnonymousView + ".plain"), ""));
              break label765;
              label697:
              locala.zqy = a.concactSpannable(localArrayList).toString();
              label711:
              locala.gv((Context)localWeakReference.get());
              locala.zqx = new com.tencent.mm.plugin.messenger.b.a(locala.zqA, locala.zqB, locala.zqC, 1);
              g.azz().a(locala.zqx, 0);
              break;
            }
            label763:
            break;
            label765:
            i += 1;
          }
        }
      }, 0, str2.length(), 33);
      AppMethodBeat.o(194486);
      return localSpannableString;
    }
  }
  
  public final String eiT()
  {
    return "new_link_succeed_contact";
  }
  
  final void gv(Context paramContext)
  {
    AppMethodBeat.i(194488);
    if (this.gtM == null)
    {
      paramContext.getString(2131755998);
      this.gtM = h.a(paramContext, paramContext.getString(2131763796), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(194482);
          g.azz().a(a.this.zqx);
          AppMethodBeat.o(194482);
        }
      });
      AppMethodBeat.o(194488);
      return;
    }
    if (!this.gtM.isShowing()) {
      this.gtM.show();
    }
    AppMethodBeat.o(194488);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(194489);
    Log.i("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "onSceneEnd errType = %d, errCode = %d, errMsg = %s, scenetype:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramq.getType()) });
    if ((this.gtM != null) && (this.gtM.isShowing())) {
      this.gtM.dismiss();
    }
    if ((paramq instanceof com.tencent.mm.plugin.messenger.b.a))
    {
      if (paramInt2 == -3600)
      {
        new f.a(MMApplicationContext.getContext()).bow(MMApplicationContext.getContext().getString(2131763791)).apa(2131768713).b(null).show();
        com.tencent.mm.plugin.messenger.e.a.Q(this.msgId, 7);
        AppMethodBeat.o(194489);
        return;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localObject = (com.tencent.mm.plugin.messenger.b.a)paramq;
        if (((com.tencent.mm.plugin.messenger.b.a)localObject).zqw == null) {}
        for (localObject = null;; localObject = ((com.tencent.mm.plugin.messenger.b.a)localObject).zqw)
        {
          paramInt1 = ((com.tencent.mm.plugin.messenger.b.a)paramq).action;
          if (localObject == null) {
            break label325;
          }
          Log.i("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "NetSceneOpenImNotAutoSucceed ret:%s action:%s", new Object[] { Integer.valueOf(((ctv)localObject).BaseResponse.Ret), Integer.valueOf(paramInt1) });
          if (paramInt1 != 1) {
            break label319;
          }
          if ((this.nhy != null) && (this.nhy.get() != null)) {
            break;
          }
          Log.e("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "NOT_AUTO_SUCCEED_ACTION_PREPARE context == null");
          AppMethodBeat.o(194489);
          return;
        }
        paramString = new f.a((Context)this.nhy.get());
        paramString.Dq(false);
        paramString.bow(this.zqy).boB(this.zqz).boA(this.lJj).c(new f.c()
        {
          public final void e(boolean paramAnonymousBoolean, String paramAnonymousString)
          {
            AppMethodBeat.i(194483);
            Log.i("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "click %s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
            if (paramAnonymousBoolean)
            {
              if ((a.this.nhy == null) || (a.this.nhy.get() == null))
              {
                Log.e("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "onDialogClick context == null");
                AppMethodBeat.o(194483);
                return;
              }
              paramAnonymousString = (Context)a.this.nhy.get();
              a.this.zqx = new com.tencent.mm.plugin.messenger.b.a(a.this.zqA, a.this.zqB, a.this.zqC, 2);
              g.azz().a(a.this.zqx, 0);
              a.this.gv(paramAnonymousString);
              com.tencent.mm.plugin.messenger.e.a.Q(a.this.msgId, 9);
              AppMethodBeat.o(194483);
              return;
            }
            com.tencent.mm.plugin.messenger.e.a.Q(a.this.msgId, 10);
            AppMethodBeat.o(194483);
          }
        }).show();
        com.tencent.mm.plugin.messenger.e.a.Q(this.msgId, 8);
        label319:
        AppMethodBeat.o(194489);
        return;
        label325:
        Log.e("MicroMsg.sysmsg.SysMsgHandlerNewLinkSucceedContact", "notAutoSucceedResp is null");
      }
      Object localObject = MMApplicationContext.getContext();
      paramq = paramString;
      if (Util.isNullOrNil(paramString)) {
        paramq = MMApplicationContext.getContext().getString(2131755804);
      }
      u.makeText((Context)localObject, paramq, 0).show();
      com.tencent.mm.plugin.messenger.e.a.Q(this.msgId, 6);
    }
    AppMethodBeat.o(194489);
  }
  
  public final void release()
  {
    AppMethodBeat.i(194485);
    super.release();
    g.azz().b(3713, this);
    AppMethodBeat.o(194485);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.c.a
 * JD-Core Version:    0.7.0.1
 */