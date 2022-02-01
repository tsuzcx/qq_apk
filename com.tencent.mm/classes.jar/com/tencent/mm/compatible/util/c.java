package com.tencent.mm.compatible.util;

import android.app.Activity;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioAttributes.Builder;
import android.media.AudioFocusRequest;
import android.media.AudioFocusRequest.Builder;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public final class c
  implements b.b
{
  private Context context;
  public b.a lYP;
  private AudioManager.OnAudioFocusChangeListener lYQ;
  private AudioManager mAudioManager;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(155870);
    this.lYQ = new AudioManager.OnAudioFocusChangeListener()
    {
      public final void onAudioFocusChange(int paramAnonymousInt)
      {
        AppMethodBeat.i(155869);
        if (c.this.lYP != null)
        {
          Log.d("MicroMsg.AudioFocusHelper", "jacks change: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          c.this.lYP.onChange(paramAnonymousInt);
        }
        AppMethodBeat.o(155869);
      }
    };
    Context localContext = paramContext;
    if ((paramContext instanceof Activity)) {
      localContext = MMApplicationContext.getContext();
    }
    this.context = localContext;
    AppMethodBeat.o(155870);
  }
  
  public final void a(b.a parama)
  {
    this.lYP = parama;
  }
  
  public final boolean aPS()
  {
    AppMethodBeat.i(155872);
    if ((this.mAudioManager == null) && (this.context != null)) {
      this.mAudioManager = ((AudioManager)this.context.getSystemService("audio"));
    }
    boolean bool;
    if (this.mAudioManager != null) {
      if (1 == this.mAudioManager.abandonAudioFocus(this.lYQ)) {
        bool = true;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(155872);
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public final int aPT()
  {
    AppMethodBeat.i(240847);
    if ((this.mAudioManager == null) && (this.context != null)) {
      this.mAudioManager = ((AudioManager)this.context.getSystemService("audio"));
    }
    if (Build.VERSION.SDK_INT >= 26)
    {
      Object localObject = new AudioAttributes.Builder().setContentType(2).setUsage(1).build();
      localObject = new AudioFocusRequest.Builder(1).setAudioAttributes((AudioAttributes)localObject).setAcceptsDelayedFocusGain(true).setOnAudioFocusChangeListener(this.lYQ).build();
      i = this.mAudioManager.requestAudioFocus((AudioFocusRequest)localObject);
      AppMethodBeat.o(240847);
      return i;
    }
    int i = this.mAudioManager.requestAudioFocus(this.lYQ, 3, 1);
    AppMethodBeat.o(240847);
    return i;
  }
  
  public final void b(b.a parama)
  {
    if (this.lYP == parama) {
      this.lYP = null;
    }
  }
  
  public final boolean requestFocus()
  {
    AppMethodBeat.i(155871);
    if ((this.mAudioManager == null) && (this.context != null)) {
      this.mAudioManager = ((AudioManager)this.context.getSystemService("audio"));
    }
    boolean bool;
    if (this.mAudioManager != null) {
      if (1 == this.mAudioManager.requestAudioFocus(this.lYQ, 3, 2)) {
        bool = true;
      }
    }
    for (;;)
    {
      Log.printInfoStack("MicroMsg.AudioFocusHelper", "jacks requestFocus: %B, %x", new Object[] { Boolean.valueOf(bool), Integer.valueOf(this.lYQ.hashCode()) });
      AppMethodBeat.o(155871);
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.compatible.util.c
 * JD-Core Version:    0.7.0.1
 */