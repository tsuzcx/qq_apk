package com.tencent.kinda.framework.widget.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.kinda.framework.module.impl.KindaCacheServiceImpl;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.framework.widget.tools.ResourcesUtils;
import com.tencent.kinda.gen.KAlertDialog;
import com.tencent.kinda.gen.TextAlign;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.kinda.gen.VoidStringCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.matrix.trace.g.b;
import com.tencent.mm.framework.app.UIPageFragmentActivity;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;

public class AlertDialogImpl
  implements KAlertDialog
{
  private static final String PATTERN_FILE = "file://";
  private static final String PATTERN_HTTP = "http://";
  private static final String PATTERN_HTTPS = "https://";
  private static final String TAG = "AlertDialogImpl";
  private KindaCacheServiceImpl kindaCacheService;
  private Dialog mDialog;
  
  public AlertDialogImpl()
  {
    AppMethodBeat.i(18742);
    this.mDialog = null;
    this.kindaCacheService = new KindaCacheServiceImpl();
    AppMethodBeat.o(18742);
  }
  
  private void finishUIPageFragmentActivity()
  {
    AppMethodBeat.i(18745);
    Activity localActivity = KindaContext.getTopOrUIPageFragmentActivity();
    if ((localActivity instanceof UIPageFragmentActivity))
    {
      if (((UIPageFragmentActivity)localActivity).adR())
      {
        ((UIPageFragmentActivity)localActivity).finish();
        AppMethodBeat.o(18745);
        return;
      }
      ac.i("AlertDialogImpl", "finishUIPageFragmentActivity, UIPageFragmentActivity shouldn't finish!");
      AppMethodBeat.o(18745);
      return;
    }
    ac.i("AlertDialogImpl", "finishUIPageFragmentActivity, UIPageFragmentActivity no found!");
    AppMethodBeat.o(18745);
  }
  
  private Drawable getDrawable(String paramString)
  {
    AppMethodBeat.i(18755);
    if (paramString != null) {
      if (paramString.startsWith("file://")) {
        paramString = f.aKz(paramString.replaceFirst("file://", ""));
      }
    }
    Bitmap localBitmap;
    for (;;)
    {
      int i;
      if (paramString != null)
      {
        paramString = new BitmapDrawable(ai.getContext().getResources(), paramString);
        AppMethodBeat.o(18755);
        return paramString;
        int j = ResourcesUtils.getDrawableId(ai.getContext(), paramString);
        i = j;
        if (j == 0) {
          i = ResourcesUtils.getResId(ai.getContext(), paramString, "raw");
        }
        localBitmap = BitmapFactory.decodeResource(ai.getContext().getResources(), i);
        paramString = localBitmap;
        if (localBitmap != null) {}
      }
      else
      {
        try
        {
          Drawable localDrawable = ai.getContext().getResources().getDrawable(i);
          paramString = localBitmap;
          if (localDrawable == null) {
            continue;
          }
          AppMethodBeat.o(18755);
          return localDrawable;
        }
        catch (Resources.NotFoundException paramString)
        {
          paramString = localBitmap;
        }
        AppMethodBeat.o(18755);
        return null;
      }
    }
  }
  
  private void setKindaDismissDialog()
  {
    AppMethodBeat.i(18744);
    if (this.kindaCacheService != null)
    {
      this.kindaCacheService.setBool("kindaShowingDialog", false, 0L);
      ac.i("AlertDialogImpl", "setKindaDismissDialog");
    }
    AppMethodBeat.o(18744);
  }
  
  private void setKindaShowingDialog()
  {
    AppMethodBeat.i(18743);
    if (this.kindaCacheService != null)
    {
      this.kindaCacheService.setBool("kindaShowingDialog", true, 0L);
      ac.i("AlertDialogImpl", "setKindaShowingDialog");
    }
    AppMethodBeat.o(18743);
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(18746);
    if (this.mDialog == null)
    {
      AppMethodBeat.o(18746);
      return;
    }
    this.mDialog.dismiss();
    this.mDialog = null;
    setKindaDismissDialog();
    finishUIPageFragmentActivity();
    AppMethodBeat.o(18746);
  }
  
  public void setContentAlign(TextAlign paramTextAlign) {}
  
  public void showImpl(String paramString1, String paramString2, String paramString3, final VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(18747);
    Context localContext = KindaContext.get();
    if (localContext == null)
    {
      ac.e("AlertDialogImpl", "AlertDialogImpl showImpl() KindaContext.get() return null! case 1");
      AppMethodBeat.o(18747);
      return;
    }
    this.mDialog = h.a(localContext, paramString2, paramString1, paramString3, false, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(18727);
        if (paramVoidCallback != null) {
          paramVoidCallback.call();
        }
        AlertDialogImpl.this.dismiss();
        AppMethodBeat.o(18727);
      }
    });
    setKindaShowingDialog();
    AppMethodBeat.o(18747);
  }
  
  public void showImpl(String paramString1, String paramString2, String paramString3, String paramString4, final VoidCallback paramVoidCallback1, final VoidCallback paramVoidCallback2)
  {
    AppMethodBeat.i(18748);
    Context localContext = KindaContext.get();
    if (localContext == null)
    {
      ac.e("AlertDialogImpl", "AlertDialogImpl showImpl() KindaContext.get() return null! case 2");
      AppMethodBeat.o(18748);
      return;
    }
    this.mDialog = h.a(localContext, paramString2, paramString1, paramString4, paramString3, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(18734);
        if (paramVoidCallback2 != null) {
          paramVoidCallback2.call();
        }
        AlertDialogImpl.this.dismiss();
        AppMethodBeat.o(18734);
      }
    }, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(18735);
        if (paramVoidCallback1 != null) {
          paramVoidCallback1.call();
        }
        AlertDialogImpl.this.dismiss();
        AppMethodBeat.o(18735);
      }
    });
    setKindaShowingDialog();
    AppMethodBeat.o(18748);
  }
  
  public void showImpl(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, final VoidCallback paramVoidCallback1, final VoidCallback paramVoidCallback2, final VoidCallback paramVoidCallback3)
  {
    AppMethodBeat.i(18749);
    paramString5 = KindaContext.get();
    if (paramString5 == null)
    {
      ac.e("AlertDialogImpl", "AlertDialogImpl showImpl() KindaContext.get() return null! case 3");
      AppMethodBeat.o(18749);
      return;
    }
    this.mDialog = h.a(paramString5, paramString2, paramString1, paramString3, paramString4, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(18736);
        if (paramVoidCallback1 != null) {
          paramVoidCallback1.call();
        }
        AlertDialogImpl.this.dismiss();
        AppMethodBeat.o(18736);
      }
    }, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(18737);
        if (paramVoidCallback2 != null) {
          paramVoidCallback2.call();
        }
        AlertDialogImpl.this.dismiss();
        AppMethodBeat.o(18737);
      }
    });
    this.mDialog.setOnCancelListener(new DialogInterface.OnCancelListener()
    {
      public void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(18738);
        if (paramVoidCallback3 != null) {
          paramVoidCallback3.call();
        }
        AlertDialogImpl.this.dismiss();
        AppMethodBeat.o(18738);
      }
    });
    setKindaShowingDialog();
    AppMethodBeat.o(18749);
  }
  
  public void showTipsImpl(String paramString1, String paramString2, String paramString3, final VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(18750);
    Context localContext = KindaContext.get();
    if (localContext == null)
    {
      ac.e("AlertDialogImpl", "AlertDialogImpl showImpl() KindaContext.get() return null! case 4");
      AppMethodBeat.o(18750);
      return;
    }
    this.mDialog = h.a(localContext, paramString2, paramString1, paramString3, false, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(18739);
        if (paramVoidCallback != null) {
          paramVoidCallback.call();
        }
        AlertDialogImpl.this.dismiss();
        AppMethodBeat.o(18739);
      }
    });
    setKindaShowingDialog();
    AppMethodBeat.o(18750);
  }
  
  public void showTipsImpl(String paramString1, String paramString2, String paramString3, String paramString4, final VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(18753);
    Object localObject = KindaContext.get();
    if (localObject == null)
    {
      ac.e("AlertDialogImpl", "AlertDialogImpl showTipsImpl() KindaContext.get() return null! case 7");
      AppMethodBeat.o(18753);
      return;
    }
    localObject = new i((Context)localObject, 2131821723);
    ((i)localObject).setContentView(2131494535);
    TextView localTextView3 = (TextView)((i)localObject).findViewById(2131305906);
    CdnImageView localCdnImageView = (CdnImageView)((i)localObject).findViewById(2131298758);
    TextView localTextView1 = (TextView)((i)localObject).findViewById(2131298778);
    TextView localTextView2 = (TextView)((i)localObject).findViewById(2131297575);
    localTextView3.setText(paramString1);
    int i;
    if (paramString2 != null)
    {
      if ((!paramString2.startsWith("http://")) && (!paramString2.startsWith("https://"))) {
        break label196;
      }
      i = 1;
      if (i == 0) {
        break label202;
      }
      localCdnImageView.setUrl(paramString2);
    }
    for (;;)
    {
      localTextView1.setText(paramString3);
      localTextView2.setText(paramString4);
      localTextView2.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(18731);
          if (paramVoidCallback != null) {
            paramVoidCallback.call();
          }
          AlertDialogImpl.this.dismiss();
          AppMethodBeat.o(18731);
        }
      });
      ((i)localObject).setCancelable(false);
      ((i)localObject).show();
      setKindaShowingDialog();
      this.mDialog = ((Dialog)localObject);
      AppMethodBeat.o(18753);
      return;
      label196:
      i = 0;
      break;
      label202:
      paramString1 = getDrawable(paramString2);
      if (paramString1 != null) {
        localCdnImageView.setImageDrawable(paramString1);
      }
    }
  }
  
  public void showTipsImpl(String paramString1, String paramString2, String paramString3, String paramString4, final VoidCallback paramVoidCallback1, final VoidCallback paramVoidCallback2)
  {
    AppMethodBeat.i(18751);
    Context localContext = KindaContext.get();
    if (localContext == null)
    {
      ac.e("AlertDialogImpl", "AlertDialogImpl showImpl() KindaContext.get() return null! case 5");
      AppMethodBeat.o(18751);
      return;
    }
    this.mDialog = h.a(localContext, paramString2, paramString1, paramString4, paramString3, false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(18740);
        if (paramVoidCallback2 != null) {
          paramVoidCallback2.call();
        }
        AlertDialogImpl.this.dismiss();
        AppMethodBeat.o(18740);
      }
    }, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(18741);
        if (paramVoidCallback1 != null) {
          paramVoidCallback1.call();
        }
        AlertDialogImpl.this.dismiss();
        AppMethodBeat.o(18741);
      }
    });
    setKindaShowingDialog();
    AppMethodBeat.o(18751);
  }
  
  public void showTipsImpl(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, final VoidCallback paramVoidCallback1, final VoidCallback paramVoidCallback2)
  {
    AppMethodBeat.i(18754);
    Object localObject = KindaContext.get();
    if (localObject == null)
    {
      ac.e("AlertDialogImpl", "AlertDialogImpl showTipsImpl() KindaContext.get() return null! case 8");
      AppMethodBeat.o(18754);
      return;
    }
    localObject = new i((Context)localObject, 2131821723);
    ((i)localObject).setContentView(2131494536);
    TextView localTextView4 = (TextView)((i)localObject).findViewById(2131305906);
    CdnImageView localCdnImageView = (CdnImageView)((i)localObject).findViewById(2131298758);
    TextView localTextView1 = (TextView)((i)localObject).findViewById(2131298778);
    TextView localTextView2 = (TextView)((i)localObject).findViewById(2131301383);
    TextView localTextView3 = (TextView)((i)localObject).findViewById(2131304179);
    localTextView4.setText(paramString1);
    int i;
    if (paramString2 != null)
    {
      if ((!paramString2.startsWith("http://")) && (!paramString2.startsWith("https://"))) {
        break label234;
      }
      i = 1;
      if (i == 0) {
        break label240;
      }
      localCdnImageView.setUrl(paramString2);
    }
    for (;;)
    {
      localTextView1.setText(paramString3);
      localTextView2.setText(paramString4);
      localTextView3.setText(paramString5);
      localTextView2.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(18732);
          if (paramVoidCallback1 != null) {
            paramVoidCallback1.call();
          }
          AlertDialogImpl.this.dismiss();
          AppMethodBeat.o(18732);
        }
      });
      localTextView3.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(18733);
          if (paramVoidCallback2 != null) {
            paramVoidCallback2.call();
          }
          AlertDialogImpl.this.dismiss();
          AppMethodBeat.o(18733);
        }
      });
      ((i)localObject).setCancelable(false);
      ((i)localObject).show();
      setKindaShowingDialog();
      this.mDialog = ((Dialog)localObject);
      AppMethodBeat.o(18754);
      return;
      label234:
      i = 0;
      break;
      label240:
      paramString1 = getDrawable(paramString2);
      if (paramString1 != null) {
        localCdnImageView.setImageDrawable(paramString1);
      }
    }
  }
  
  public void showTipsImpl(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, final VoidCallback paramVoidCallback1, final VoidCallback paramVoidCallback2, final VoidCallback paramVoidCallback3)
  {
    AppMethodBeat.i(18752);
    Object localObject = KindaContext.get();
    if (localObject == null)
    {
      ac.e("AlertDialogImpl", "AlertDialogImpl showTipsImpl() KindaContext.get() return null! case 6");
      AppMethodBeat.o(18752);
      return;
    }
    localObject = new i((Context)localObject, 2131821723);
    ((i)localObject).setContentView(2131494539);
    TextView localTextView1 = (TextView)((i)localObject).findViewById(2131301279);
    TextView localTextView2 = (TextView)((i)localObject).findViewById(2131301278);
    TextView localTextView3 = (TextView)((i)localObject).findViewById(2131301275);
    TextView localTextView4 = (TextView)((i)localObject).findViewById(2131301276);
    TextView localTextView5 = (TextView)((i)localObject).findViewById(2131301277);
    if (!b.cX(paramString1))
    {
      localTextView1.setVisibility(0);
      localTextView1.setText(paramString1);
    }
    if (!b.cX(paramString2))
    {
      localTextView2.setVisibility(0);
      localTextView2.setText(paramString2);
    }
    localTextView3.setText(paramString3);
    localTextView4.setText(paramString4);
    localTextView5.setText(paramString5);
    localTextView3.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(18728);
        if (paramVoidCallback1 != null) {
          paramVoidCallback1.call();
        }
        AlertDialogImpl.this.dismiss();
        AppMethodBeat.o(18728);
      }
    });
    localTextView4.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(18729);
        if (paramVoidCallback2 != null) {
          paramVoidCallback2.call();
        }
        AlertDialogImpl.this.dismiss();
        AppMethodBeat.o(18729);
      }
    });
    localTextView5.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(18730);
        if (paramVoidCallback3 != null) {
          paramVoidCallback3.call();
        }
        AlertDialogImpl.this.dismiss();
        AppMethodBeat.o(18730);
      }
    });
    ((i)localObject).setCancelable(false);
    ((i)localObject).show();
    setKindaShowingDialog();
    this.mDialog = ((Dialog)localObject);
    AppMethodBeat.o(18752);
  }
  
  public void showTouchIdAuthViewImpl(String paramString, VoidStringCallback paramVoidStringCallback, VoidCallback paramVoidCallback1, VoidCallback paramVoidCallback2, VoidCallback paramVoidCallback3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.AlertDialogImpl
 * JD-Core Version:    0.7.0.1
 */