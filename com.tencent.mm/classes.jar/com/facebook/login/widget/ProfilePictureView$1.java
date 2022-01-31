package com.facebook.login.widget;

import com.facebook.internal.ImageRequest.Callback;
import com.facebook.internal.ImageResponse;
import com.tencent.matrix.trace.core.AppMethodBeat;

class ProfilePictureView$1
  implements ImageRequest.Callback
{
  ProfilePictureView$1(ProfilePictureView paramProfilePictureView) {}
  
  public void onCompleted(ImageResponse paramImageResponse)
  {
    AppMethodBeat.i(92688);
    ProfilePictureView.access$000(this.this$0, paramImageResponse);
    AppMethodBeat.o(92688);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.login.widget.ProfilePictureView.1
 * JD-Core Version:    0.7.0.1
 */