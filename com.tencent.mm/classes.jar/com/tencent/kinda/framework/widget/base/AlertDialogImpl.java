package com.tencent.kinda.framework.widget.base;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.framework.widget.tools.ResourcesUtils;
import com.tencent.kinda.gen.KAlertDialog;
import com.tencent.kinda.gen.TextAlign;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.kinda.gen.VoidStringCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.i;

public class AlertDialogImpl
  implements KAlertDialog
{
  private static final String PATTERN_FILE = "file://";
  private static final String PATTERN_HTTP = "http://";
  private static final String PATTERN_HTTPS = "https://";
  private Dialog mDialog = null;
  
  private Drawable getDrawable(String paramString)
  {
    AppMethodBeat.i(144639);
    if (paramString != null) {
      if (paramString.startsWith("file://")) {
        paramString = d.aoV(paramString.replaceFirst("file://", ""));
      }
    }
    Bitmap localBitmap;
    for (;;)
    {
      int i;
      if (paramString != null)
      {
        paramString = new BitmapDrawable(ah.getContext().getResources(), paramString);
        AppMethodBeat.o(144639);
        return paramString;
        int j = ResourcesUtils.getDrawableId(ah.getContext(), paramString);
        i = j;
        if (j == 0) {
          i = ResourcesUtils.getResId(ah.getContext(), paramString, "raw");
        }
        localBitmap = BitmapFactory.decodeResource(ah.getContext().getResources(), i);
        paramString = localBitmap;
        if (localBitmap != null) {}
      }
      else
      {
        try
        {
          Drawable localDrawable = ah.getContext().getResources().getDrawable(i);
          paramString = localBitmap;
          if (localDrawable == null) {
            continue;
          }
          AppMethodBeat.o(144639);
          return localDrawable;
        }
        catch (Resources.NotFoundException paramString)
        {
          paramString = localBitmap;
        }
        AppMethodBeat.o(144639);
        return null;
      }
    }
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(144630);
    if (this.mDialog == null)
    {
      AppMethodBeat.o(144630);
      return;
    }
    this.mDialog.dismiss();
    this.mDialog = null;
    AppMethodBeat.o(144630);
  }
  
  public void setContentAlign(TextAlign paramTextAlign) {}
  
  public void showImpl(String paramString1, String paramString2, String paramString3, final VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(144631);
    Context localContext = KindaContext.get();
    if (localContext == null)
    {
      AppMethodBeat.o(144631);
      return;
    }
    this.mDialog = h.a(localContext, paramString2, paramString1, paramString3, false, new DialogInterface.OnClickListener()
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(144615);
        paramVoidCallback.call();
        AlertDialogImpl.access$002(AlertDialogImpl.this, null);
        AppMethodBeat.o(144615);
      }
    });
    AppMethodBeat.o(144631);
  }
  
  public void showImpl(String paramString1, String paramString2, String paramString3, String paramString4, VoidCallback paramVoidCallback1, final VoidCallback paramVoidCallback2)
  {
    AppMethodBeat.i(144632);
    Context localContext = KindaContext.get();
    if (localContext == null)
    {
      AppMethodBeat.o(144632);
      return;
    }
    this.mDialog = h.a(localContext, paramString2, paramString1, paramString4, paramString3, false, new DialogInterface.OnClickListener()new AlertDialogImpl.3
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(144622);
        paramVoidCallback2.call();
        AlertDialogImpl.access$002(AlertDialogImpl.this, null);
        AppMethodBeat.o(144622);
      }
    }, new AlertDialogImpl.3(this, paramVoidCallback1));
    AppMethodBeat.o(144632);
  }
  
  public void showImpl(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, VoidCallback paramVoidCallback1, VoidCallback paramVoidCallback2, VoidCallback paramVoidCallback3)
  {
    AppMethodBeat.i(144633);
    paramString5 = KindaContext.get();
    if (paramString5 == null)
    {
      AppMethodBeat.o(144633);
      return;
    }
    this.mDialog = h.a(paramString5, paramString2, paramString1, paramString3, paramString4, false, new AlertDialogImpl.4(this, paramVoidCallback1), new AlertDialogImpl.5(this, paramVoidCallback2));
    this.mDialog.setOnCancelListener(new AlertDialogImpl.6(this, paramVoidCallback3));
    AppMethodBeat.o(144633);
  }
  
  public void showTipsImpl(String paramString1, String paramString2, String paramString3, VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(144634);
    Context localContext = KindaContext.get();
    if (localContext == null)
    {
      AppMethodBeat.o(144634);
      return;
    }
    this.mDialog = h.a(localContext, paramString2, paramString1, paramString3, false, new AlertDialogImpl.7(this, paramVoidCallback));
    AppMethodBeat.o(144634);
  }
  
  public void showTipsImpl(String paramString1, String paramString2, String paramString3, String paramString4, final VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(144637);
    Object localObject = KindaContext.get();
    if (localObject == null)
    {
      AppMethodBeat.o(144637);
      return;
    }
    localObject = new i((Context)localObject, 2131493881);
    ((i)localObject).setContentView(2130969955);
    TextView localTextView3 = (TextView)((i)localObject).findViewById(2131821335);
    CdnImageView localCdnImageView = (CdnImageView)((i)localObject).findViewById(2131825334);
    TextView localTextView1 = (TextView)((i)localObject).findViewById(2131823022);
    TextView localTextView2 = (TextView)((i)localObject).findViewById(2131825335);
    localTextView3.setText(paramString1);
    int i;
    if (paramString2 != null)
    {
      if ((!paramString2.startsWith("http://")) && (!paramString2.startsWith("https://"))) {
        break label182;
      }
      i = 1;
      if (i == 0) {
        break label188;
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
          AppMethodBeat.i(144619);
          if (paramVoidCallback != null) {
            paramVoidCallback.call();
          }
          AlertDialogImpl.this.dismiss();
          AppMethodBeat.o(144619);
        }
      });
      ((i)localObject).setCancelable(false);
      ((i)localObject).show();
      this.mDialog = ((Dialog)localObject);
      AppMethodBeat.o(144637);
      return;
      label182:
      i = 0;
      break;
      label188:
      paramString1 = getDrawable(paramString2);
      if (paramString1 != null) {
        localCdnImageView.setImageDrawable(paramString1);
      }
    }
  }
  
  public void showTipsImpl(String paramString1, String paramString2, String paramString3, String paramString4, VoidCallback paramVoidCallback1, final VoidCallback paramVoidCallback2)
  {
    AppMethodBeat.i(144635);
    Context localContext = KindaContext.get();
    if (localContext == null)
    {
      AppMethodBeat.o(144635);
      return;
    }
    this.mDialog = h.a(localContext, paramString2, paramString1, paramString4, paramString3, false, new DialogInterface.OnClickListener()new AlertDialogImpl.9
    {
      public void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(144628);
        paramVoidCallback2.call();
        AlertDialogImpl.access$002(AlertDialogImpl.this, null);
        AppMethodBeat.o(144628);
      }
    }, new AlertDialogImpl.9(this, paramVoidCallback1));
    AppMethodBeat.o(144635);
  }
  
  public void showTipsImpl(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, final VoidCallback paramVoidCallback1, VoidCallback paramVoidCallback2)
  {
    AppMethodBeat.i(144638);
    Object localObject = KindaContext.get();
    if (localObject == null)
    {
      AppMethodBeat.o(144638);
      return;
    }
    localObject = new i((Context)localObject, 2131493881);
    ((i)localObject).setContentView(2130969956);
    TextView localTextView4 = (TextView)((i)localObject).findViewById(2131821335);
    CdnImageView localCdnImageView = (CdnImageView)((i)localObject).findViewById(2131825334);
    TextView localTextView1 = (TextView)((i)localObject).findViewById(2131823022);
    TextView localTextView2 = (TextView)((i)localObject).findViewById(2131823924);
    TextView localTextView3 = (TextView)((i)localObject).findViewById(2131823890);
    localTextView4.setText(paramString1);
    int i;
    if (paramString2 != null)
    {
      if ((!paramString2.startsWith("http://")) && (!paramString2.startsWith("https://"))) {
        break label216;
      }
      i = 1;
      if (i == 0) {
        break label222;
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
          AppMethodBeat.i(144620);
          if (paramVoidCallback1 != null) {
            paramVoidCallback1.call();
          }
          AlertDialogImpl.this.dismiss();
          AppMethodBeat.o(144620);
        }
      });
      localTextView3.setOnClickListener(new AlertDialogImpl.15(this, paramVoidCallback2));
      ((i)localObject).setCancelable(false);
      ((i)localObject).show();
      this.mDialog = ((Dialog)localObject);
      AppMethodBeat.o(144638);
      return;
      label216:
      i = 0;
      break;
      label222:
      paramString1 = getDrawable(paramString2);
      if (paramString1 != null) {
        localCdnImageView.setImageDrawable(paramString1);
      }
    }
  }
  
  public void showTipsImpl(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, VoidCallback paramVoidCallback1, final VoidCallback paramVoidCallback2, final VoidCallback paramVoidCallback3)
  {
    AppMethodBeat.i(144636);
    paramString1 = KindaContext.get();
    if (paramString1 == null)
    {
      AppMethodBeat.o(144636);
      return;
    }
    paramString1 = new i(paramString1, 2131493881);
    paramString1.setContentView(2130969959);
    TextView localTextView1 = (TextView)paramString1.findViewById(2131825338);
    TextView localTextView2 = (TextView)paramString1.findViewById(2131825339);
    TextView localTextView3 = (TextView)paramString1.findViewById(2131825340);
    TextView localTextView4 = (TextView)paramString1.findViewById(2131825341);
    localTextView1.setText(paramString2);
    localTextView2.setText(paramString3);
    localTextView3.setText(paramString4);
    localTextView4.setText(paramString5);
    localTextView2.setOnClickListener(new AlertDialogImpl.10(this, paramVoidCallback1));
    localTextView3.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(144617);
        if (paramVoidCallback2 != null) {
          paramVoidCallback2.call();
        }
        AlertDialogImpl.this.dismiss();
        AppMethodBeat.o(144617);
      }
    });
    localTextView4.setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(144618);
        if (paramVoidCallback3 != null) {
          paramVoidCallback3.call();
        }
        AlertDialogImpl.this.dismiss();
        AppMethodBeat.o(144618);
      }
    });
    paramString1.setCancelable(false);
    paramString1.show();
    this.mDialog = paramString1;
    AppMethodBeat.o(144636);
  }
  
  public void showTouchIdAuthViewImpl(String paramString, VoidStringCallback paramVoidStringCallback, VoidCallback paramVoidCallback1, VoidCallback paramVoidCallback2, VoidCallback paramVoidCallback3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.AlertDialogImpl
 * JD-Core Version:    0.7.0.1
 */