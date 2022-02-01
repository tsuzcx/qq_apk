package androidx.core.app;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Parcelable;
import androidx.core.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class k
{
  static final class a
  {
    static void a(Intent paramIntent, ArrayList<Uri> paramArrayList)
    {
      AppMethodBeat.i(196330);
      Object localObject2 = paramIntent.getCharSequenceExtra("android.intent.extra.TEXT");
      String str = paramIntent.getStringExtra("android.intent.extra.HTML_TEXT");
      Object localObject1 = paramIntent.getType();
      localObject2 = new ClipData.Item((CharSequence)localObject2, str, null, (Uri)paramArrayList.get(0));
      localObject1 = new ClipData(null, new String[] { localObject1 }, (ClipData.Item)localObject2);
      int j = paramArrayList.size();
      int i = 1;
      while (i < j)
      {
        ((ClipData)localObject1).addItem(new ClipData.Item((Uri)paramArrayList.get(i)));
        i += 1;
      }
      paramIntent.setClipData((ClipData)localObject1);
      paramIntent.addFlags(1);
      AppMethodBeat.o(196330);
    }
  }
  
  public static final class b
  {
    private ArrayList<String> bpQ;
    private ArrayList<String> bpR;
    private ArrayList<String> bpS;
    private ArrayList<Uri> bpT;
    private final Context mContext;
    private final Intent mIntent;
    
    private b(Context paramContext)
    {
      AppMethodBeat.i(196359);
      this.mContext = ((Context)f.checkNotNull(paramContext));
      this.mIntent = new Intent().setAction("android.intent.action.SEND");
      this.mIntent.putExtra("androidx.core.app.EXTRA_CALLING_PACKAGE", paramContext.getPackageName());
      this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE", paramContext.getPackageName());
      this.mIntent.addFlags(524288);
      if ((paramContext instanceof ContextWrapper)) {
        if (!(paramContext instanceof Activity)) {}
      }
      for (paramContext = (Activity)paramContext;; paramContext = null)
      {
        if (paramContext != null)
        {
          paramContext = paramContext.getComponentName();
          this.mIntent.putExtra("androidx.core.app.EXTRA_CALLING_ACTIVITY", paramContext);
          this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY", paramContext);
        }
        AppMethodBeat.o(196359);
        return;
        paramContext = ((ContextWrapper)paramContext).getBaseContext();
        break;
      }
    }
    
    private void b(String paramString, ArrayList<String> paramArrayList)
    {
      AppMethodBeat.i(196371);
      String[] arrayOfString1 = this.mIntent.getStringArrayExtra(paramString);
      if (arrayOfString1 != null) {}
      for (int i = arrayOfString1.length;; i = 0)
      {
        String[] arrayOfString2 = new String[paramArrayList.size() + i];
        paramArrayList.toArray(arrayOfString2);
        if (arrayOfString1 != null) {
          System.arraycopy(arrayOfString1, 0, arrayOfString2, paramArrayList.size(), i);
        }
        this.mIntent.putExtra(paramString, arrayOfString2);
        AppMethodBeat.o(196371);
        return;
      }
    }
    
    @Deprecated
    public static b h(Activity paramActivity)
    {
      AppMethodBeat.i(196348);
      paramActivity = new b(paramActivity);
      AppMethodBeat.o(196348);
      return paramActivity;
    }
    
    public final b as(String paramString)
    {
      AppMethodBeat.i(196393);
      this.mIntent.setType(paramString);
      AppMethodBeat.o(196393);
      return this;
    }
    
    public final b at(String paramString)
    {
      AppMethodBeat.i(196415);
      this.mIntent.putExtra("android.intent.extra.SUBJECT", paramString);
      AppMethodBeat.o(196415);
      return this;
    }
    
    public final Intent getIntent()
    {
      int i = 1;
      AppMethodBeat.i(196384);
      if (this.bpQ != null)
      {
        b("android.intent.extra.EMAIL", this.bpQ);
        this.bpQ = null;
      }
      if (this.bpR != null)
      {
        b("android.intent.extra.CC", this.bpR);
        this.bpR = null;
      }
      if (this.bpS != null)
      {
        b("android.intent.extra.BCC", this.bpS);
        this.bpS = null;
      }
      if ((this.bpT != null) && (this.bpT.size() > 1))
      {
        if (i != 0) {
          break label221;
        }
        this.mIntent.setAction("android.intent.action.SEND");
        if ((this.bpT == null) || (this.bpT.isEmpty())) {
          break label179;
        }
        this.mIntent.putExtra("android.intent.extra.STREAM", (Parcelable)this.bpT.get(0));
        if (Build.VERSION.SDK_INT >= 16) {
          k.a.a(this.mIntent, this.bpT);
        }
      }
      for (;;)
      {
        Intent localIntent = this.mIntent;
        AppMethodBeat.o(196384);
        return localIntent;
        i = 0;
        break;
        label179:
        this.mIntent.removeExtra("android.intent.extra.STREAM");
        if (Build.VERSION.SDK_INT >= 16)
        {
          localIntent = this.mIntent;
          localIntent.setClipData(null);
          localIntent.setFlags(localIntent.getFlags() & 0xFFFFFFFE);
          continue;
          label221:
          this.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
          this.mIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.bpT);
          if (Build.VERSION.SDK_INT >= 16) {
            k.a.a(this.mIntent, this.bpT);
          }
        }
      }
    }
    
    public final b q(CharSequence paramCharSequence)
    {
      AppMethodBeat.i(196404);
      this.mIntent.putExtra("android.intent.extra.TEXT", paramCharSequence);
      AppMethodBeat.o(196404);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     androidx.core.app.k
 * JD-Core Version:    0.7.0.1
 */