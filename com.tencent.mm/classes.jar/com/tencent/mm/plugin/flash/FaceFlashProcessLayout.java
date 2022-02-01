package com.tencent.mm.plugin.flash;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.compatible.util.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import org.json.JSONException;
import org.json.JSONObject;

public class FaceFlashProcessLayout
  extends RelativeLayout
{
  static String TAG = "MicroMsg.FaceFlashManager";
  private static String wHv = "MicroMsg.FaceFlashManagerError";
  private FaceFlashUI wGP;
  private TextView wHA;
  Animation wHB;
  Animation wHC;
  Animation wHD;
  TextView wHw;
  WeImageView wHx;
  ImageView wHy;
  Button wHz;
  
  public FaceFlashProcessLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceFlashProcessLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private FaceFlashProcessLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, 0);
    AppMethodBeat.i(186468);
    this.wGP = ((FaceFlashUI)getContext());
    this.wHB = AnimationUtils.loadAnimation(getContext(), 2130772041);
    this.wHC = AnimationUtils.loadAnimation(getContext(), 2130772043);
    this.wHD = AnimationUtils.loadAnimation(getContext(), 2130772042);
    LayoutInflater.from(getContext()).inflate(2131494072, this, true);
    this.wHw = ((TextView)findViewById(2131300342));
    this.wHx = ((WeImageView)findViewById(2131300341));
    this.wHz = ((Button)findViewById(2131300338));
    this.wHA = ((TextView)findViewById(2131300337));
    this.wHy = ((ImageView)findViewById(2131300340));
    AppMethodBeat.o(186468);
  }
  
  public final void axe(String paramString)
  {
    AppMethodBeat.i(186469);
    Log.i(TAG, "showFailedAnimation");
    try
    {
      this.wHy.setImageResource(2131232242);
      this.wHy.startAnimation(this.wHB);
      this.wHx.setImageDrawable(com.tencent.mm.cb.a.l(getContext(), 2131690548));
      this.wHx.startAnimation(this.wHD);
      final JSONObject localJSONObject = new JSONObject(paramString);
      this.wHw.setText(com.tencent.mm.plugin.flash.d.a.k(localJSONObject, com.tencent.mm.cb.a.aI(getContext(), 2131759001)));
      final String str = localJSONObject.optString("err_feedback", "");
      Object localObject = this.wHA;
      int i;
      final boolean bool;
      if (TextUtils.isEmpty(str))
      {
        i = 4;
        ((TextView)localObject).setVisibility(i);
        this.wHA.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(186465);
            Object localObject = new b();
            ((b)localObject).bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/flash/FaceFlashProcessLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
            try
            {
              paramAnonymousView = q.encode(String.format("appid=%s;errcode=%d;identifyid=%s", new Object[] { localJSONObject.optString("key_app_id", ""), Integer.valueOf(localJSONObject.optInt("err_code", 0)), localJSONObject.optString("verify_result", "") }), "UTF-8");
              paramAnonymousView = str + "?customInfo=" + paramAnonymousView;
              localObject = new Intent();
              ((Intent)localObject).putExtra("rawUrl", paramAnonymousView);
              c.b(FaceFlashProcessLayout.this.getContext(), "webview", ".ui.tools.WebViewUI", (Intent)localObject);
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/flash/FaceFlashProcessLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(186465);
              return;
            }
            catch (Exception paramAnonymousView)
            {
              for (;;)
              {
                Log.printErrStackTrace(FaceFlashProcessLayout.wHv, paramAnonymousView, "face start feedback webview exception", new Object[0]);
              }
            }
          }
        });
        bool = localJSONObject.optBoolean("err_retry", true);
        this.wHz.setVisibility(0);
        localObject = this.wHz;
        if (!bool) {
          break label217;
        }
      }
      label217:
      for (str = com.tencent.mm.cb.a.aI(getContext(), 2131759083);; str = com.tencent.mm.cb.a.aI(getContext(), 2131759081))
      {
        ((Button)localObject).setText(str);
        this.wHz.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(186466);
            b localb = new b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/flash/FaceFlashProcessLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            if (bool) {
              FaceFlashProcessLayout.a(FaceFlashProcessLayout.this).reset();
            }
            for (;;)
            {
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/flash/FaceFlashProcessLayout$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(186466);
              return;
              FaceFlashProcessLayout.a(FaceFlashProcessLayout.this).aO(localJSONObject);
            }
          }
        });
        AppMethodBeat.o(186469);
        return;
        i = 0;
        break;
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      Log.printErrStackTrace(wHv, localJSONException, "parse face failed result error.%s", new Object[] { paramString });
      this.wHw.setText(paramString);
      this.wHA.setVisibility(4);
      this.wHz.setVisibility(0);
      this.wHz.setText(com.tencent.mm.cb.a.aI(getContext(), 2131759083));
      this.wHz.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(186467);
          b localb = new b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/flash/FaceFlashProcessLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          FaceFlashProcessLayout.a(FaceFlashProcessLayout.this).reset();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/flash/FaceFlashProcessLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(186467);
        }
      });
      AppMethodBeat.o(186469);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.flash.FaceFlashProcessLayout
 * JD-Core Version:    0.7.0.1
 */