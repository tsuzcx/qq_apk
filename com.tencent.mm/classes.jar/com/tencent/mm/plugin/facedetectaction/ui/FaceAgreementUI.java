package com.tencent.mm.plugin.facedetectaction.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.facedetect.model.l;
import com.tencent.mm.plugin.facedetectaction.a.c;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.bbx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.ui.widget.a.j;
import java.util.List;

public class FaceAgreementUI
  extends MMActivity
  implements f
{
  private j lca;
  private com.tencent.mm.ui.widget.a.g plh;
  private TextView ryC;
  private Button ryD;
  private LinearLayout ryE;
  private TextView ryF;
  private TextView ryG;
  private TextView ryH;
  private ImageView ryI;
  private String ryJ = "";
  private boolean ryK = false;
  private boolean ryL = false;
  
  private void a(final Context paramContext, List<String> paramList1, String paramString, List<String> paramList2, final TextView paramTextView)
  {
    AppMethodBeat.i(188666);
    final SpannableString localSpannableString = new SpannableString(paramString);
    int i = 0;
    while (i < paramList2.size())
    {
      String str = (String)paramList2.get(i);
      int j = paramString.indexOf(str);
      int k = j + str.length();
      if ((j >= 0) && (k <= paramString.length())) {
        localSpannableString.setSpan(new a((String)paramList1.get(i), ak.getContext().getResources().getColor(2131100547), ak.getContext().getResources().getColor(2131099658), new a.a()
        {
          public final void agX(String paramAnonymousString)
          {
            AppMethodBeat.i(188658);
            ae.i("MicroMsg.FaceAgreementUI", "click %s", new Object[] { paramAnonymousString });
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", paramAnonymousString);
            com.tencent.mm.br.d.b(paramContext, "webview", ".ui.tools.WebViewUI", localIntent);
            AppMethodBeat.o(188658);
          }
        }), j, k, 17);
      }
      i += 1;
    }
    if (paramTextView != null)
    {
      paramTextView.setText(localSpannableString);
      paramTextView.setOnTouchListener(new View.OnTouchListener()
      {
        public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
        {
          AppMethodBeat.i(188659);
          Object localObject1 = new b();
          ((b)localObject1).bd(paramAnonymousView);
          ((b)localObject1).bd(paramAnonymousMotionEvent);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetectaction/ui/FaceAgreementUI$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, ((b)localObject1).ahF());
          int j = paramAnonymousMotionEvent.getAction();
          paramAnonymousView = (TextView)paramAnonymousView;
          int k;
          int i;
          if ((j == 1) || (j == 3))
          {
            localObject1 = (ClickableSpan[])localSpannableString.getSpans(0, localSpannableString.length(), ClickableSpan.class);
            if ((localObject1 != null) && (localObject1.length > 0))
            {
              k = localObject1.length;
              i = 0;
              while (i < k)
              {
                Object localObject2 = localObject1[i];
                if ((localObject2 instanceof o))
                {
                  ((o)localObject2).setIsPressed(false);
                  paramTextView.invalidate();
                }
                i += 1;
              }
            }
          }
          if ((j == 1) || (j == 0))
          {
            i = (int)paramAnonymousMotionEvent.getX();
            k = (int)paramAnonymousMotionEvent.getY();
            int m = paramAnonymousView.getPaddingLeft();
            int n = paramAnonymousView.getPaddingTop();
            int i1 = paramAnonymousView.getScrollX();
            int i2 = paramAnonymousView.getScrollY();
            paramAnonymousMotionEvent = paramAnonymousView.getLayout();
            i = paramAnonymousMotionEvent.getOffsetForHorizontal(paramAnonymousMotionEvent.getLineForVertical(k - n + i2), i - m + i1);
            paramAnonymousMotionEvent = (ClickableSpan[])localSpannableString.getSpans(i, i, ClickableSpan.class);
            if (paramAnonymousMotionEvent.length != 0)
            {
              paramAnonymousMotionEvent = paramAnonymousMotionEvent[0];
              if (j == 1) {
                paramAnonymousMotionEvent.onClick(paramAnonymousView);
              }
            }
          }
          for (boolean bool = true;; bool = false)
          {
            ae.i("MicroMsg.FaceAgreementUI", "touch ${event.x}, ${event.y}, ret:${ret}");
            com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/plugin/facedetectaction/ui/FaceAgreementUI$6", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
            AppMethodBeat.o(188659);
            return bool;
            if ((paramAnonymousMotionEvent instanceof o))
            {
              ((o)paramAnonymousMotionEvent).setIsPressed(true);
              paramTextView.invalidate();
            }
            Selection.setSelection(localSpannableString, localSpannableString.getSpanStart(paramAnonymousMotionEvent), localSpannableString.getSpanEnd(paramAnonymousMotionEvent));
            break;
            Selection.removeSelection(localSpannableString);
          }
        }
      });
    }
    AppMethodBeat.o(188666);
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return 2131496387;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(188665);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    setResult(paramInt2, paramIntent);
    finish();
    AppMethodBeat.o(188665);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(188664);
    ae.i("MicroMsg.FaceAgreementUI", "onBackPressed()");
    Intent localIntent = new Intent();
    localIntent.putExtra("err_code", l.DZ(90024));
    localIntent.putExtra("err_msg", "cancel");
    setResult(0, localIntent);
    super.onBackPressed();
    AppMethodBeat.o(188664);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(188662);
    super.onCreate(paramBundle);
    this.ryC = ((TextView)findViewById(2131308097));
    this.ryD = ((Button)findViewById(2131308102));
    this.ryE = ((LinearLayout)findViewById(2131308099));
    this.ryF = ((TextView)findViewById(2131308100));
    this.ryG = ((TextView)findViewById(2131308101));
    al.a(this.ryG.getPaint(), 0.8F);
    this.ryD.setEnabled(true);
    this.ryD.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(188654);
        Object localObject = new b();
        ((b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetectaction/ui/FaceAgreementUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
        ae.i("MicroMsg.FaceAgreementUI", "needShowProtocal : %s", new Object[] { Boolean.valueOf(FaceAgreementUI.a(FaceAgreementUI.this)) });
        if (FaceAgreementUI.a(FaceAgreementUI.this)) {
          FaceAgreementUI.b(FaceAgreementUI.this);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetectaction/ui/FaceAgreementUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(188654);
          return;
          paramAnonymousView = new Intent(FaceAgreementUI.this, FaceActionUI.class);
          localObject = FaceAgreementUI.this.getIntent().getExtras();
          if (localObject != null) {
            paramAnonymousView.putExtras((Bundle)localObject);
          }
          FaceAgreementUI.this.startActivityForResult(paramAnonymousView, 1);
          com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(917L, 67L, 1L, false);
        }
      }
    });
    setMMTitle("");
    setActionbarColor(getResources().getColor(2131101179));
    getSupportActionBar().hide();
    this.ryI = ((ImageView)findViewById(2131308483));
    this.ryI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(188655);
        b localb = new b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/facedetectaction/ui/FaceAgreementUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        FaceAgreementUI.c(FaceAgreementUI.this);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/facedetectaction/ui/FaceAgreementUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(188655);
      }
    });
    this.lca = j.c(this, "", false);
    com.tencent.mm.kernel.g.ajj().a(1108, this);
    int i = getIntent().getIntExtra("scene", 0);
    paramBundle = getIntent().getStringExtra("package");
    String str = getIntent().getStringExtra("packageSign");
    com.tencent.mm.kernel.g.ajj().a(new c(i, paramBundle, str), 0);
    AppMethodBeat.o(188662);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(188667);
    super.onDestroy();
    if (this.ryL) {
      com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(917L, 63L, 1L, false);
    }
    AppMethodBeat.o(188667);
  }
  
  public void onSceneEnd(final int paramInt1, final int paramInt2, final String paramString, final n paramn)
  {
    AppMethodBeat.i(188663);
    com.tencent.mm.kernel.g.ajj().b(1108, this);
    h.MqF.aM(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(188656);
        if ((paramInt1 == 0) && (paramInt2 == 0))
        {
          FaceAgreementUI.d(FaceAgreementUI.this);
          int i = ((c)paramn).rxm.GRR;
          localObject = ((c)paramn).rxm.GRS;
          FaceAgreementUI.a(FaceAgreementUI.this, ((c)paramn).rxm.DqC);
          ae.i("MicroMsg.FaceAgreementUI", "[cgi-ret]contractRet:%s  tip:%s url:%s", new Object[] { Integer.valueOf(i), localObject, FaceAgreementUI.e(FaceAgreementUI.this) });
          if (i == 1)
          {
            FaceAgreementUI.a(FaceAgreementUI.this, false);
            FaceAgreementUI.f(FaceAgreementUI.this).setEnabled(true);
            if (!FaceAgreementUI.a(FaceAgreementUI.this)) {
              break label239;
            }
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(917L, 62L, 1L, false);
          }
          for (;;)
          {
            FaceAgreementUI.h(FaceAgreementUI.this).setText((CharSequence)localObject);
            AppMethodBeat.o(188656);
            return;
            if (TextUtils.isEmpty(FaceAgreementUI.e(FaceAgreementUI.this)))
            {
              FaceAgreementUI.a(FaceAgreementUI.this, false);
              FaceAgreementUI.g(FaceAgreementUI.this).setVisibility(4);
              FaceAgreementUI.f(FaceAgreementUI.this).setEnabled(true);
              break;
            }
            FaceAgreementUI.a(FaceAgreementUI.this, true);
            com.tencent.mm.plugin.facedetectaction.b.d.rxC.rxM = true;
            break;
            label239:
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(917L, 61L, 1L, false);
          }
        }
        com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(917L, 72L, 1L, false);
        FaceAgreementUI.a(FaceAgreementUI.this, false);
        ae.e("MicroMsg.FaceAgreementUIError", "[cgi-ret]net ret error, errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
        FaceAgreementUI.d(FaceAgreementUI.this);
        Object localObject = new Intent();
        ((Intent)localObject).putExtra("err_msg", "fail");
        ((Intent)localObject).putExtra("err_code", 90110);
        FaceAgreementUI.this.setResult(1, (Intent)localObject);
        FaceAgreementUI.this.finish();
        AppMethodBeat.o(188656);
      }
    });
    AppMethodBeat.o(188663);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceAgreementUI
 * JD-Core Version:    0.7.0.1
 */