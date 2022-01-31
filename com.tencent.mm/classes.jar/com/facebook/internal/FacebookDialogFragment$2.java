package com.facebook.internal;

import android.os.Bundle;
import com.facebook.FacebookException;
import com.tencent.matrix.trace.core.AppMethodBeat;

class FacebookDialogFragment$2
  implements WebDialog.OnCompleteListener
{
  FacebookDialogFragment$2(FacebookDialogFragment paramFacebookDialogFragment) {}
  
  public void onComplete(Bundle paramBundle, FacebookException paramFacebookException)
  {
    AppMethodBeat.i(96630);
    FacebookDialogFragment.access$100(this.this$0, paramBundle);
    AppMethodBeat.o(96630);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.internal.FacebookDialogFragment.2
 * JD-Core Version:    0.7.0.1
 */