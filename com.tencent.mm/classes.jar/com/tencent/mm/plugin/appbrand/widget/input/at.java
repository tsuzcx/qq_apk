package com.tencent.mm.plugin.appbrand.widget.input;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.i.b;
import com.tencent.mm.vfs.y;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"ENCRYPTED_VALUE_KEY", "", "ENCRYPT_ERR_MSG_KEY", "SAFE_PASSWORD_CERT_PATH_KEY", "SAFE_PASSWORD_COMPAT_KEY", "SAFE_PASSWORD_ERR_MSG_CERT_PATH_ILLEGAL", "SAFE_PASSWORD_ERR_MSG_ENV_ERROR", "SAFE_PASSWORD_ERR_MSG_NEED_CERT_PATH", "SAFE_PASSWORD_ERR_MSG_NEED_NONCE", "SAFE_PASSWORD_ERR_MSG_NEED_SALT_OR_CUSTOM_HASH", "SAFE_PASSWORD_ERR_MSG_NEED_TIME_STAMP", "SAFE_PASSWORD_ERR_MSG_SDK_ERROR", "SAFE_PASSWORD_KEY", "SAFE_PASSWORD_LENGTH_KEY", "SAFE_PASSWORD_NONCE_KEY", "SAFE_PASSWORD_SALT_KEY", "SAFE_PASSWORD_TIME_STAMP_KEY", "SECURE_INPUT_DEBUG", "", "VIEW_ID_KEY", "getSecureInputRootPath", "toArray", "", "Ljava/nio/ByteBuffer;", "luggage-wxa-app-input-ext_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class at
{
  public static final byte[] F(ByteBuffer paramByteBuffer)
  {
    AppMethodBeat.i(324453);
    s.u(paramByteBuffer, "<this>");
    byte[] arrayOfByte = new byte[paramByteBuffer.remaining()];
    paramByteBuffer.get(arrayOfByte);
    AppMethodBeat.o(324453);
    return arrayOfByte;
  }
  
  public static final String cRP()
  {
    AppMethodBeat.i(324449);
    String str = b.bns();
    y.bDX(str);
    str = y.n(str, true);
    AppMethodBeat.o(324449);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.at
 * JD-Core Version:    0.7.0.1
 */