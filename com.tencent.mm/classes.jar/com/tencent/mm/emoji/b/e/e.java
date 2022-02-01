package com.tencent.mm.emoji.b.e;

import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.j;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/loader/task/ProcessTask;", "Lcom/tencent/mm/emoji/loader/task/IEmojiLoadTask;", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiInfo;)V", "getTaskKey", "", "run", "", "Companion", "IPCLoadEmoji", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends c
{
  public static final e.a mhs;
  
  static
  {
    AppMethodBeat.i(242737);
    mhs = new e.a((byte)0);
    AppMethodBeat.o(242737);
  }
  
  public e(EmojiInfo paramEmojiInfo)
  {
    super(paramEmojiInfo);
    AppMethodBeat.i(105484);
    AppMethodBeat.o(105484);
  }
  
  private static final void a(e parame, Bundle paramBundle)
  {
    boolean bool = false;
    AppMethodBeat.i(242736);
    s.u(parame, "this$0");
    if (paramBundle == null) {}
    for (;;)
    {
      parame.onResult(bool);
      AppMethodBeat.o(242736);
      return;
      bool = paramBundle.getBoolean("KEY_RESULT", false);
    }
  }
  
  public final String aUD()
  {
    AppMethodBeat.i(105481);
    String str = this.mgK.getMd5();
    s.s(str, "emojiInfo.md5");
    AppMethodBeat.o(105481);
    return str;
  }
  
  public final void run()
  {
    AppMethodBeat.i(105482);
    super.run();
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("KEY_DATA", (Parcelable)this.mgK);
    localBundle.setClassLoader(EmojiInfo.class.getClassLoader());
    j.a(MMApplicationContext.getMainProcessName(), (Parcelable)localBundle, e.b.class, new e..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(105482);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.e.e
 * JD-Core Version:    0.7.0.1
 */