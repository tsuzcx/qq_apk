package com.facebook.share.internal;

import android.os.Bundle;
import com.facebook.internal.PlatformServiceClient.CompletedListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

class LikeActionController$10
  implements PlatformServiceClient.CompletedListener
{
  LikeActionController$10(LikeActionController paramLikeActionController) {}
  
  public void completed(Bundle paramBundle)
  {
    AppMethodBeat.i(96981);
    if ((paramBundle == null) || (!paramBundle.containsKey("com.facebook.platform.extra.OBJECT_IS_LIKED")))
    {
      AppMethodBeat.o(96981);
      return;
    }
    boolean bool = paramBundle.getBoolean("com.facebook.platform.extra.OBJECT_IS_LIKED");
    String str1;
    String str2;
    label64:
    String str3;
    label81:
    String str4;
    if (paramBundle.containsKey("com.facebook.platform.extra.LIKE_COUNT_STRING_WITH_LIKE"))
    {
      str1 = paramBundle.getString("com.facebook.platform.extra.LIKE_COUNT_STRING_WITH_LIKE");
      if (!paramBundle.containsKey("com.facebook.platform.extra.LIKE_COUNT_STRING_WITHOUT_LIKE")) {
        break label147;
      }
      str2 = paramBundle.getString("com.facebook.platform.extra.LIKE_COUNT_STRING_WITHOUT_LIKE");
      if (!paramBundle.containsKey("com.facebook.platform.extra.SOCIAL_SENTENCE_WITH_LIKE")) {
        break label159;
      }
      str3 = paramBundle.getString("com.facebook.platform.extra.SOCIAL_SENTENCE_WITH_LIKE");
      if (!paramBundle.containsKey("com.facebook.platform.extra.SOCIAL_SENTENCE_WITHOUT_LIKE")) {
        break label171;
      }
      str4 = paramBundle.getString("com.facebook.platform.extra.SOCIAL_SENTENCE_WITHOUT_LIKE");
      label98:
      if (!paramBundle.containsKey("com.facebook.platform.extra.UNLIKE_TOKEN")) {
        break label183;
      }
    }
    label147:
    label159:
    label171:
    label183:
    for (paramBundle = paramBundle.getString("com.facebook.platform.extra.UNLIKE_TOKEN");; paramBundle = LikeActionController.access$1100(this.this$0))
    {
      LikeActionController.access$1300(this.this$0, bool, str1, str2, str3, str4, paramBundle);
      AppMethodBeat.o(96981);
      return;
      str1 = LikeActionController.access$700(this.this$0);
      break;
      str2 = LikeActionController.access$800(this.this$0);
      break label64;
      str3 = LikeActionController.access$900(this.this$0);
      break label81;
      str4 = LikeActionController.access$1000(this.this$0);
      break label98;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.share.internal.LikeActionController.10
 * JD-Core Version:    0.7.0.1
 */