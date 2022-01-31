package com.samsung.android.sdk.look.writingbuddy;

import android.graphics.Bitmap;
import com.samsung.android.writingbuddy.WritingBuddyImpl.OnImageWritingListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

class SlookWritingBuddy$2
  implements WritingBuddyImpl.OnImageWritingListener
{
  SlookWritingBuddy$2(SlookWritingBuddy paramSlookWritingBuddy) {}
  
  public void onImageReceived(Bitmap paramBitmap)
  {
    AppMethodBeat.i(117193);
    SlookWritingBuddy.access$100(this.this$0).onImageReceived(paramBitmap);
    AppMethodBeat.o(117193);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.samsung.android.sdk.look.writingbuddy.SlookWritingBuddy.2
 * JD-Core Version:    0.7.0.1
 */